package com.kaneki.done.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.kaneki.done.model.entity.DayEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAY_ENTITY".
*/
public class DayEntityDao extends AbstractDao<DayEntity, Long> {

    public static final String TABLENAME = "DAY_ENTITY";

    /**
     * Properties of entity DayEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DoneId = new Property(1, long.class, "doneId", false, "DONE_ID");
        public final static Property Date = new Property(2, java.util.Date.class, "date", false, "DATE");
        public final static Property Target_goals = new Property(3, int.class, "target_goals", false, "TARGET_GOALS");
        public final static Property Current_goals = new Property(4, int.class, "current_goals", false, "CURRENT_GOALS");
        public final static Property Tag = new Property(5, String.class, "tag", false, "TAG");
    }

    private Query<DayEntity> doneEntity_DayDatasQuery;

    public DayEntityDao(DaoConfig config) {
        super(config);
    }
    
    public DayEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAY_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DONE_ID\" INTEGER NOT NULL ," + // 1: doneId
                "\"DATE\" INTEGER NOT NULL ," + // 2: date
                "\"TARGET_GOALS\" INTEGER NOT NULL ," + // 3: target_goals
                "\"CURRENT_GOALS\" INTEGER NOT NULL ," + // 4: current_goals
                "\"TAG\" TEXT);"); // 5: tag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAY_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DayEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDoneId());
        stmt.bindLong(3, entity.getDate().getTime());
        stmt.bindLong(4, entity.getTarget_goals());
        stmt.bindLong(5, entity.getCurrent_goals());
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(6, tag);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DayEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDoneId());
        stmt.bindLong(3, entity.getDate().getTime());
        stmt.bindLong(4, entity.getTarget_goals());
        stmt.bindLong(5, entity.getCurrent_goals());
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(6, tag);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DayEntity readEntity(Cursor cursor, int offset) {
        DayEntity entity = new DayEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // doneId
            new java.util.Date(cursor.getLong(offset + 2)), // date
            cursor.getInt(offset + 3), // target_goals
            cursor.getInt(offset + 4), // current_goals
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // tag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DayEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDoneId(cursor.getLong(offset + 1));
        entity.setDate(new java.util.Date(cursor.getLong(offset + 2)));
        entity.setTarget_goals(cursor.getInt(offset + 3));
        entity.setCurrent_goals(cursor.getInt(offset + 4));
        entity.setTag(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DayEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DayEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DayEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "dayDatas" to-many relationship of DoneEntity. */
    public List<DayEntity> _queryDoneEntity_DayDatas(long doneId) {
        synchronized (this) {
            if (doneEntity_DayDatasQuery == null) {
                QueryBuilder<DayEntity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.DoneId.eq(null));
                doneEntity_DayDatasQuery = queryBuilder.build();
            }
        }
        Query<DayEntity> query = doneEntity_DayDatasQuery.forCurrentThread();
        query.setParameter(0, doneId);
        return query.list();
    }

}
