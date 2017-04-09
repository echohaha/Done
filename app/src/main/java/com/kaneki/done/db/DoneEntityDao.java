package com.kaneki.done.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.kaneki.done.model.entity.DoneEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DONE_ENTITY".
*/
public class DoneEntityDao extends AbstractDao<DoneEntity, Long> {

    public static final String TABLENAME = "DONE_ENTITY";

    /**
     * Properties of entity DoneEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Type = new Property(2, int.class, "type", false, "TYPE");
        public final static Property Color = new Property(3, int.class, "color", false, "COLOR");
        public final static Property Target_goals = new Property(4, int.class, "target_goals", false, "TARGET_GOALS");
        public final static Property Current_goals = new Property(5, int.class, "current_goals", false, "CURRENT_GOALS");
        public final static Property Longest_streak = new Property(6, int.class, "longest_streak", false, "LONGEST_STREAK");
        public final static Property Current_streak = new Property(7, int.class, "current_streak", false, "CURRENT_STREAK");
        public final static Property Tag = new Property(8, String.class, "tag", false, "TAG");
    }

    private DaoSession daoSession;


    public DoneEntityDao(DaoConfig config) {
        super(config);
    }
    
    public DoneEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DONE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"TYPE\" INTEGER NOT NULL ," + // 2: type
                "\"COLOR\" INTEGER NOT NULL ," + // 3: color
                "\"TARGET_GOALS\" INTEGER NOT NULL ," + // 4: target_goals
                "\"CURRENT_GOALS\" INTEGER NOT NULL ," + // 5: current_goals
                "\"LONGEST_STREAK\" INTEGER NOT NULL ," + // 6: longest_streak
                "\"CURRENT_STREAK\" INTEGER NOT NULL ," + // 7: current_streak
                "\"TAG\" TEXT);"); // 8: tag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DONE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DoneEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getType());
        stmt.bindLong(4, entity.getColor());
        stmt.bindLong(5, entity.getTarget_goals());
        stmt.bindLong(6, entity.getCurrent_goals());
        stmt.bindLong(7, entity.getLongest_streak());
        stmt.bindLong(8, entity.getCurrent_streak());
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(9, tag);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DoneEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getType());
        stmt.bindLong(4, entity.getColor());
        stmt.bindLong(5, entity.getTarget_goals());
        stmt.bindLong(6, entity.getCurrent_goals());
        stmt.bindLong(7, entity.getLongest_streak());
        stmt.bindLong(8, entity.getCurrent_streak());
 
        String tag = entity.getTag();
        if (tag != null) {
            stmt.bindString(9, tag);
        }
    }

    @Override
    protected final void attachEntity(DoneEntity entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DoneEntity readEntity(Cursor cursor, int offset) {
        DoneEntity entity = new DoneEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // type
            cursor.getInt(offset + 3), // color
            cursor.getInt(offset + 4), // target_goals
            cursor.getInt(offset + 5), // current_goals
            cursor.getInt(offset + 6), // longest_streak
            cursor.getInt(offset + 7), // current_streak
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // tag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DoneEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setType(cursor.getInt(offset + 2));
        entity.setColor(cursor.getInt(offset + 3));
        entity.setTarget_goals(cursor.getInt(offset + 4));
        entity.setCurrent_goals(cursor.getInt(offset + 5));
        entity.setLongest_streak(cursor.getInt(offset + 6));
        entity.setCurrent_streak(cursor.getInt(offset + 7));
        entity.setTag(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DoneEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DoneEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DoneEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
