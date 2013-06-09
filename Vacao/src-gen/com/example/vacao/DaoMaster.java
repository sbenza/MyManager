package com.example.vacao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.example.vacao.CattleDao;
import com.example.vacao.BullOriginDao;
import com.example.vacao.VaccineDao;
import com.example.vacao.VaccineControlDao;
import com.example.vacao.PalpationControlDao;
import com.example.vacao.InseminationControlDao;
import com.example.vacao.TaggingControlDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 3): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 3;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        CattleDao.createTable(db, ifNotExists);
        BullOriginDao.createTable(db, ifNotExists);
        VaccineDao.createTable(db, ifNotExists);
        VaccineControlDao.createTable(db, ifNotExists);
        PalpationControlDao.createTable(db, ifNotExists);
        InseminationControlDao.createTable(db, ifNotExists);
        TaggingControlDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        CattleDao.dropTable(db, ifExists);
        BullOriginDao.dropTable(db, ifExists);
        VaccineDao.dropTable(db, ifExists);
        VaccineControlDao.dropTable(db, ifExists);
        PalpationControlDao.dropTable(db, ifExists);
        InseminationControlDao.dropTable(db, ifExists);
        TaggingControlDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(CattleDao.class);
        registerDaoClass(BullOriginDao.class);
        registerDaoClass(VaccineDao.class);
        registerDaoClass(VaccineControlDao.class);
        registerDaoClass(PalpationControlDao.class);
        registerDaoClass(InseminationControlDao.class);
        registerDaoClass(TaggingControlDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
