package com.example.museumapp.bean.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.museumapp.bean.OrderRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_RECORD".
*/
public class OrderRecordDao extends AbstractDao<OrderRecord, Void> {

    public static final String TABLENAME = "ORDER_RECORD";

    /**
     * Properties of entity OrderRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property User_id = new Property(0, String.class, "user_id", false, "USER_ID");
        public final static Property Username = new Property(1, String.class, "username", false, "USERNAME");
        public final static Property Time = new Property(2, String.class, "time", false, "TIME");
        public final static Property Phone = new Property(3, String.class, "phone", false, "PHONE");
        public final static Property Count = new Property(4, String.class, "count", false, "COUNT");
    }


    public OrderRecordDao(DaoConfig config) {
        super(config);
    }
    
    public OrderRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_RECORD\" (" + //
                "\"USER_ID\" TEXT," + // 0: user_id
                "\"USERNAME\" TEXT," + // 1: username
                "\"TIME\" TEXT," + // 2: time
                "\"PHONE\" TEXT," + // 3: phone
                "\"COUNT\" TEXT);"); // 4: count
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ORDER_RECORD_USER_ID ON \"ORDER_RECORD\"" +
                " (\"USER_ID\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_RECORD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderRecord entity) {
        stmt.clearBindings();
 
        String user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindString(1, user_id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(2, username);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(5, count);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderRecord entity) {
        stmt.clearBindings();
 
        String user_id = entity.getUser_id();
        if (user_id != null) {
            stmt.bindString(1, user_id);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(2, username);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(3, time);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(5, count);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public OrderRecord readEntity(Cursor cursor, int offset) {
        OrderRecord entity = new OrderRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // user_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // username
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // time
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // phone
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // count
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderRecord entity, int offset) {
        entity.setUser_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUsername(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(OrderRecord entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(OrderRecord entity) {
        return null;
    }

    @Override
    public boolean hasKey(OrderRecord entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
