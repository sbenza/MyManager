package com.example.vacao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.example.vacao.VaccineControl;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table VaccineControl.
*/
public class VaccineControlDao extends AbstractDao<VaccineControl, Long> {

    public static final String TABLENAME = "VaccineControl";

    /**
     * Properties of entity VaccineControl.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Comment = new Property(1, String.class, "comment", false, "COMMENT");
        public final static Property Dose = new Property(2, String.class, "dose", false, "DOSE");
        public final static Property Date = new Property(3, java.util.Date.class, "date", false, "DATE");
        public final static Property CattleId = new Property(4, long.class, "cattleId", false, "CATTLE_ID");
        public final static Property VaccineId = new Property(5, long.class, "vaccineId", false, "VACCINE_ID");
    };

    private DaoSession daoSession;

    private Query<VaccineControl> cattle_VaccineControlQuery;
    private Query<VaccineControl> vaccine_VaccineControlListQuery;

    public VaccineControlDao(DaoConfig config) {
        super(config);
    }
    
    public VaccineControlDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'VaccineControl' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'COMMENT' TEXT," + // 1: comment
                "'DOSE' TEXT," + // 2: dose
                "'DATE' INTEGER," + // 3: date
                "'CATTLE_ID' INTEGER NOT NULL ," + // 4: cattleId
                "'VACCINE_ID' INTEGER NOT NULL );"); // 5: vaccineId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'VaccineControl'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, VaccineControl entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(2, comment);
        }
 
        String dose = entity.getDose();
        if (dose != null) {
            stmt.bindString(3, dose);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
        stmt.bindLong(5, entity.getCattleId());
        stmt.bindLong(6, entity.getVaccineId());
    }

    @Override
    protected void attachEntity(VaccineControl entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public VaccineControl readEntity(Cursor cursor, int offset) {
        VaccineControl entity = new VaccineControl( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // comment
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // dose
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // date
            cursor.getLong(offset + 4), // cattleId
            cursor.getLong(offset + 5) // vaccineId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, VaccineControl entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setComment(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDose(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setCattleId(cursor.getLong(offset + 4));
        entity.setVaccineId(cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(VaccineControl entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(VaccineControl entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "VaccineControl" to-many relationship of Cattle. */
    public List<VaccineControl> _queryCattle_VaccineControl(long cattleId) {
        synchronized (this) {
            if (cattle_VaccineControlQuery == null) {
                QueryBuilder<VaccineControl> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CattleId.eq(null));
                cattle_VaccineControlQuery = queryBuilder.build();
            }
        }
        Query<VaccineControl> query = cattle_VaccineControlQuery.forCurrentThread();
        query.setParameter(0, cattleId);
        return query.list();
    }

    /** Internal query to resolve the "vaccineControlList" to-many relationship of Vaccine. */
    public List<VaccineControl> _queryVaccine_VaccineControlList(long vaccineId) {
        synchronized (this) {
            if (vaccine_VaccineControlListQuery == null) {
                QueryBuilder<VaccineControl> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.VaccineId.eq(null));
                vaccine_VaccineControlListQuery = queryBuilder.build();
            }
        }
        Query<VaccineControl> query = vaccine_VaccineControlListQuery.forCurrentThread();
        query.setParameter(0, vaccineId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCattleDao().getAllColumns());
            builder.append(" FROM VaccineControl T");
            builder.append(" LEFT JOIN CATTLE T0 ON T.'CATTLE_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected VaccineControl loadCurrentDeep(Cursor cursor, boolean lock) {
        VaccineControl entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Cattle cattle = loadCurrentOther(daoSession.getCattleDao(), cursor, offset);
         if(cattle != null) {
            entity.setCattle(cattle);
        }

        return entity;    
    }

    public VaccineControl loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<VaccineControl> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<VaccineControl> list = new ArrayList<VaccineControl>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<VaccineControl> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<VaccineControl> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
