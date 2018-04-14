package com.example.gemery.groupradioaddfragment.bean;

/**
 * Created by gemery on 2018/4/14.
 */

public class User {
    private UserInfo author;
    private String thumb;
    private String video;
    private String _id;
    private String title ;
    private int total;

    @Override
    public String toString() {
        return "User{" +
                "userInfo=" + author +
                ", thumb='" + thumb + '\'' +
                ", video='" + video + '\'' +
                ", _id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", total=" + total +
                '}';
    }

    public UserInfo getUserInfo() {
        return author;
    }

    public void setUserInfo(UserInfo author) {
        this.author = author;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public class UserInfo{
       private String avatar;
       private String nickname;

       public String getAvatar() {
           return avatar;
       }

       public void setAvatar(String avatar) {
           this.avatar = avatar;
       }

       public String getNickName() {
           return nickname;
       }

       public void setNickName(String nickName) {
           this.nickname = nickname;
       }

       @Override
       public String toString() {
           return "UserInfo{" +
                   "avatar='" + avatar + '\'' +
                   ", nickName='" + nickname + '\'' +
                   '}';
       }
   }
}
