package com.speedystone.greendaodemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.implementtest.Role;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROLE".
*/
public class RoleDao extends AbstractDao<Role, String> {

    public static final String TABLENAME = "ROLE";

    /**
     * Properties of entity Role.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "Name", true, "NAME");
        public final static Property HP = new Property(1, int.class, "HP", false, "HP");
        public final static Property MaxHP = new Property(2, int.class, "MaxHP", false, "MAX_HP");
        public final static Property MP = new Property(3, int.class, "MP", false, "MP");
        public final static Property Max_MP = new Property(4, int.class, "Max_MP", false, "MAX__MP");
        public final static Property ATK = new Property(5, int.class, "ATK", false, "ATK");
        public final static Property MATK = new Property(6, int.class, "MATK", false, "MATK");
        public final static Property DEF = new Property(7, int.class, "DEF", false, "DEF");
        public final static Property MDEF = new Property(8, int.class, "MDEF", false, "MDEF");
        public final static Property AGI = new Property(9, int.class, "AGI", false, "AGI");
    }


    public RoleDao(DaoConfig config) {
        super(config);
    }
    
    public RoleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROLE\" (" + //
                "\"NAME\" TEXT PRIMARY KEY NOT NULL ," + // 0: Name
                "\"HP\" INTEGER NOT NULL ," + // 1: HP
                "\"MAX_HP\" INTEGER NOT NULL ," + // 2: MaxHP
                "\"MP\" INTEGER NOT NULL ," + // 3: MP
                "\"MAX__MP\" INTEGER NOT NULL ," + // 4: Max_MP
                "\"ATK\" INTEGER NOT NULL ," + // 5: ATK
                "\"MATK\" INTEGER NOT NULL ," + // 6: MATK
                "\"DEF\" INTEGER NOT NULL ," + // 7: DEF
                "\"MDEF\" INTEGER NOT NULL ," + // 8: MDEF
                "\"AGI\" INTEGER NOT NULL );"); // 9: AGI
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Role entity) {
        stmt.clearBindings();
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(1, Name);
        }
        stmt.bindLong(2, entity.getHP());
        stmt.bindLong(3, entity.getMaxHP());
        stmt.bindLong(4, entity.getMP());
        stmt.bindLong(5, entity.getMax_MP());
        stmt.bindLong(6, entity.getATK());
        stmt.bindLong(7, entity.getMATK());
        stmt.bindLong(8, entity.getDEF());
        stmt.bindLong(9, entity.getMDEF());
        stmt.bindLong(10, entity.getAGI());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Role entity) {
        stmt.clearBindings();
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(1, Name);
        }
        stmt.bindLong(2, entity.getHP());
        stmt.bindLong(3, entity.getMaxHP());
        stmt.bindLong(4, entity.getMP());
        stmt.bindLong(5, entity.getMax_MP());
        stmt.bindLong(6, entity.getATK());
        stmt.bindLong(7, entity.getMATK());
        stmt.bindLong(8, entity.getDEF());
        stmt.bindLong(9, entity.getMDEF());
        stmt.bindLong(10, entity.getAGI());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public Role readEntity(Cursor cursor, int offset) {
        Role entity = new Role( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // Name
            cursor.getInt(offset + 1), // HP
            cursor.getInt(offset + 2), // MaxHP
            cursor.getInt(offset + 3), // MP
            cursor.getInt(offset + 4), // Max_MP
            cursor.getInt(offset + 5), // ATK
            cursor.getInt(offset + 6), // MATK
            cursor.getInt(offset + 7), // DEF
            cursor.getInt(offset + 8), // MDEF
            cursor.getInt(offset + 9) // AGI
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Role entity, int offset) {
        entity.setName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setHP(cursor.getInt(offset + 1));
        entity.setMaxHP(cursor.getInt(offset + 2));
        entity.setMP(cursor.getInt(offset + 3));
        entity.setMax_MP(cursor.getInt(offset + 4));
        entity.setATK(cursor.getInt(offset + 5));
        entity.setMATK(cursor.getInt(offset + 6));
        entity.setDEF(cursor.getInt(offset + 7));
        entity.setMDEF(cursor.getInt(offset + 8));
        entity.setAGI(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Role entity, long rowId) {
        return entity.getName();
    }
    
    @Override
    public String getKey(Role entity) {
        if(entity != null) {
            return entity.getName();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Role entity) {
        return entity.getName() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
