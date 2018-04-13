package com.example.gemery.groupradioaddfragment.db;

import android.content.Context;

import com.example.gemery.groupradioaddfragment.dao.UserInfoDao;
import com.example.gemery.groupradioaddfragment.entity.UserInfo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by gemery on 2018/4/13.
 */

public class UserDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, UserInfo stu) {
        DbManager.getDaoSession(context).getUserInfoDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<UserInfo> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getUserInfoDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param userInfo
     */
    public static void saveData(Context context, UserInfo userInfo) {
        DbManager.getDaoSession(context).getUserInfoDao().save(userInfo);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param userInfo 删除具体内容
     */
    public static void deleteData(Context context, UserInfo userInfo) {
        DbManager.getDaoSession(context).getUserInfoDao().delete(userInfo);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getUserInfoDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getUserInfoDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param userInfo
     */
    public static void updateData(Context context, UserInfo userInfo) {
        DbManager.getDaoSession(context).getUserInfoDao().update(userInfo);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<UserInfo> queryAll(Context context) {
        QueryBuilder<UserInfo> builder = DbManager.getDaoSession(context).getUserInfoDao().queryBuilder();

        return builder.build().list();
    }



    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<UserInfo> queryPaging( int pageSize, int pageNum,Context context){
        UserInfoDao studentDao = DbManager.getDaoSession(context).getUserInfoDao();
        List<UserInfo> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
}
