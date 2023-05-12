package com.example.museumapp.bean.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private static DatabaseManager databaseManager;
    /**
     * 数据库会话
     */
    private DaoSession mSession;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;

    private DatabaseManager() {}

    /**
     * 初始化数据库
     * @param context
     */
    public synchronized void initDataBase(Context context) {
        //获取需要连接的数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "museumApp.db");
        db = devOpenHelper.getWritableDatabase();
        //创建数据库连接
        daoMaster = new DaoMaster(db);
        //创建会话
        mSession = daoMaster.newSession();
    }

    public static synchronized DatabaseManager getInstance() {
        if (databaseManager == null){
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    /**
     * 获取User dao
     * @return
     */
    public UserDao getUserDao() {return mSession.getUserDao();}

    /**
     * 获取OrderRecord dao
     * @return
     */
    public OrderRecordDao getOrderRecordDao() {return mSession.getOrderRecordDao();}


}
