package com.example.gemery.ssww.service;


import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;


import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.gemery.ssww.AppExample;
import com.example.gemery.ssww.listener.CheckConnectionListener;
import com.example.gemery.ssww.listener.FriendsPacketListener;
import com.example.gemery.ssww.listener.MsgListener;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.XmppConnectionManager;


/**
 * @author 白玉梁
 */
public class MsfService extends Service{

	private static MsfService mInstance = null;
	public static DatagramSocket ds = null;

	private NotificationManager mNotificationManager;

	private String mUserName, mPassword;
	private XmppConnectionManager mXmppConnectionManager;
	private XMPPConnection mXMPPConnection;
	
	private CheckConnectionListener checkConnectionListener;
	private FriendsPacketListener friendsPacketListener;
	
	private final IBinder binder = new MyBinder();

	public class MyBinder extends Binder {
		public MsfService getService() {
			return MsfService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		mUserName = PreferencesUtils.getSharePreStr(this, "username");
		mPassword = PreferencesUtils.getSharePreStr(this, "pwd");
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);         // 通知
		mXmppConnectionManager = XmppConnectionManager.getInstance();
		initXMPPTask();		
	}

	public static MsfService getInstance() {
		return mInstance;
	}
	

	/**
	 * 初始化xmpp和完成后台登录
	 */
	private void initXMPPTask() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
				    initXMPP();	
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
	 * 初始化XMPP
	 */
	void initXMPP() {
		mXMPPConnection = mXmppConnectionManager.init();						//初始化XMPPConnection
		loginXMPP();															//登录XMPP
		ChatManager chatmanager = mXMPPConnection.getChatManager();
		chatmanager.addChatListener(new ChatManagerListener() {
			@Override
			public void chatCreated(Chat chat, boolean arg1) {
				chat.addMessageListener(new MsgListener(MsfService.this, mNotificationManager));
//				chat.addMessageListener(new MessageListener() {
//					@Override
//					public void processMessage(Chat chat, Message message) {
//						String msg = message.getBody();
//					}
//				});
			}
		});
	}

	/**
	 * 登录XMPP
	 */
	void loginXMPP() {
		try {
			mPassword = PreferencesUtils.getSharePreStr(this, "pwd");
			mXMPPConnection.connect();
			Log.e("jj","连接成功。。。。。。。。");
		    try{
		    	if(checkConnectionListener!=null){
		    		mXMPPConnection.removeConnectionListener(checkConnectionListener);
		    		checkConnectionListener=null;
		    	}
		    }catch(Exception e){
		    	
		    }
			mXMPPConnection.login(mUserName, mPassword);
			if(mXMPPConnection.isAuthenticated()){                                     //登录成功
				AppExample.xmppConnection=mXMPPConnection;
				sendLoginBroadcast(true);
				//添加xmpp连接监听
				checkConnectionListener=new CheckConnectionListener(this);               
				mXMPPConnection.addConnectionListener(checkConnectionListener);	
				// 注册好友状态更新监听
				friendsPacketListener=new FriendsPacketListener(this);
				PacketFilter filter = new AndFilter(new PacketTypeFilter(Presence.class));
				mXMPPConnection.addPacketListener(friendsPacketListener, filter); 
			}else{
				sendLoginBroadcast(false);
				stopSelf();                                                                                        //如果登录失败，自动销毁Service
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendLoginBroadcast(false);
			stopSelf();
		}
	}
	
	/**
	 * 发送登录状态广播
	 * @param isLoginSuccess
	 */
	void sendLoginBroadcast(boolean isLoginSuccess){
		Intent intent =new Intent(Const.ACTION_IS_LOGIN_SUCCESS);
		intent.putExtra("isLoginSuccess", isLoginSuccess);
		sendBroadcast(intent);
	}
	

	@Override
	public void onDestroy() {
		if(mNotificationManager!=null){
			
		}
		try {
			if (mXMPPConnection != null) {
				mXMPPConnection.disconnect();
				mXMPPConnection = null;
			}
			if(mXmppConnectionManager!=null){
				mXmppConnectionManager = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.onDestroy();
	}

}
