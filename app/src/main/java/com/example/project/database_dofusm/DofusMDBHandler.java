package com.example.project.database_dofusm;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.project.appclasses.Personnage;
import com.example.project.appclasses.Equipement;
import com.example.project.enumdofusm.Align;
import com.example.project.enumdofusm.Classes;

public class DofusMDBHandler extends SQLiteOpenHelper {
 
    // Logcat tag
    private static final String LOG = DofusMDBHandler.class.getName();
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "chara_dofusm";
 
    // Table Names
    private static final String TABLE_PERSO = "personnage";
    private static final String TABLE_CLASSE = "classe";
    private static final String TABLE_ALIGNEMENT = "alignement";
	private static final String TABLE_JOB = "job";
	private static final String TABLE_JOBNAME = "jobname";
	private static final String TABLE_EQUIPEMENT = "equipement";
 
    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
 
    // PERSO Table - column names
    private static final String KEY_LEVEL = "level";
    private static final String KEY_NAME = "name";
	private static final String KEY_SUCCESS = "success";
    private static final String KEY_KOLIZEUM = "kolizeum";
	
	private static final String KEY_CLASSE_ID = "classe_id";
    private static final String KEY_ALIGNEMENT_ID = "alignement_id";
	private static final String KEY_JOB_ID = "job_id";
    private static final String KEY_EQUIPEMENT_ID = "equipement_id";
 
    // CLASSE Table - column names
    private static final String KEY_CLASSE_NAME = "classe_name";
 
    // ALIGNEMENT Table - column names
    private static final String KEY_ALIGNEMENT_NAME = "alignement_name";

    // JOB Table - column names
    private static final String KEY_JOB_LEVEL = "job_level";
    private static final String KEY_JOBNAME_ID = "jobname_id";
	
	// JOBNAME Table - column names
    private static final String KEY_JOBNAME_NAME = "jobname_name";
	
	// EQUIPEMENT Table - column names
    //private static final String KEY_EQUIPEMENT_ = "jobname_name";
 
    // Table Create Statements
    // Perso table create statement
    private static final String CREATE_TABLE_PERSO = "CREATE TABLE "
            + TABLE_PERSO + "(" + KEY_ID + " INTEGER PRIMARY KEY," 
			+ KEY_LEVEL + " INTEGER,"
			+ KEY_NAME + "TEXT,"
			+ KEY_SUCCESS + " INTEGER,"
			+ KEY_KOLIZEUM + " INTEGER,"
			+ KEY_CLASSE_ID + " INTEGER,"
			+ KEY_ALIGNEMENT_ID + " INTEGER,"
			+ KEY_JOB_ID + " INTEGER,"
			+ KEY_EQUIPEMENT_ID + " INTEGER,"
			+KEY_CREATED_AT + " DATETIME" + ")";
 
    // Classe table create statement
    private static final String CREATE_TABLE_CLASSE = "CREATE TABLE " 
			+ TABLE_CLASSE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_CLASSE_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";
 
    // Alignement table create statement
    private static final String CREATE_TABLE_ALIGNEMENT = "CREATE TABLE "
            + TABLE_ALIGNEMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_ALIGNEMENT_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";
			
	// JobName table create statement
    private static final String CREATE_TABLE_JOBNAME = "CREATE TABLE "
            + TABLE_JOBNAME + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_JOBNAME_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";
	
	// Job table create statement
	private static final String CREATE_TABLE_JOB = "CREATE TABLE "
            + TABLE_JOB + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			+ KEY_JOB_LEVEL + " INTEGER,"
			+ KEY_JOBNAME_ID + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";
			
	// Equipement table create statement
	private static final String CREATE_TABLE_EQUIPEMENT = "CREATE TABLE "
            + TABLE_EQUIPEMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
			
            + KEY_CREATED_AT + " DATETIME" + ")";
 
    public DofusMDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_JOBNAME);
        db.execSQL(CREATE_TABLE_JOB);
        db.execSQL(CREATE_TABLE_EQUIPEMENT);
		db.execSQL(CREATE_TABLE_ALIGNEMENT);
        db.execSQL(CREATE_TABLE_CLASSE);
		db.execSQL(CREATE_TABLE_PERSO);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBNAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EQUIPEMENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALIGNEMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASSE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSO);
 
        // create new tables
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long addPersoHandler(Personnage perso, Equipement eq) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LEVEL, perso.getLevel());
        values.put(KEY_NAME, perso.getName());
        values.put(KEY_SUCCESS , perso.getSuccess());
        values.put(KEY_KOLIZEUM , perso.getKolizeum());

        // values.put(KEY_CLASSE_ID , perso.getCla().getId());
        // values.put(KEY_ALIGNEMENT_ID + " INTEGER,");
        // values.put(KEY_JOB_ID + " INTEGER,");
        // values.put(KEY_EQUIPEMENT_ID);

        values.put(KEY_CREATED_AT, getDateTime());


        // insert row
        long perso_id = db.insert(TABLE_PERSO, null, values);

        // assigning tags to todo
        for (long tag_id : tag_ids) {
            createTodoTag(todo_id, tag_id);
        }
        return perso_id;
    }

    public boolean updatePersoHandler(Personnage perso) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(KEY_ID, perso.ID);
        args.put(KEY_NAME, name);
        return db.update(KEY_NAME, args, KEY_ID + "=" + ID, null) > 0;
    }

    public boolean deletePersoHandler(int ID) {

        boolean result = false;
        String query = "Select * FROM" + TABLE_PERSO + "WHERE" + KEY_ID + "= '" + ID + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Personnage perso = new Personnage();

        if (cursor.moveToFirst()) {
            perso.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PERSO, KEY_ID + "=?",
                    new String[] {
                String.valueOf(perso.getId())
            });
            cursor.close();
            result = true;
        }

        db.close();

        return result;

    }

    public boolean addClasse() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;
        boolean classe_initialized = false;
        long classe_id;
        for (Classes cla : Classes.values()) {
            values = new ContentValues();
            values.put(KEY_ID, 0000);
            values.put(KEY_CLASSE_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            classe_id = db.insert(TABLE_CLASSE, null, values);
            classe_initialized = true;
        }
        return classe_initialized;
    }

    public boolean addAlign() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;
        boolean align_initialized = false;
        long align_id;
        for (Align cla : Align.values()) {
            values = new ContentValues();
            values.put(KEY_ID, 0000);
            values.put(KEY_ALIGNEMENT_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            align_id = db.insert(TABLE_ALIGNEMENT, null, values);
            align_initialized = true;
        }
        return align_initialized;
    }

    public Personnage findPersoHandler(String perso_id) {
        String query = "Select * FROM " + TABLE_PERSO + "WHERE" + KEY_ID + " = " + "'" + perso_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Personnage perso = new Personnage();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            perso.setId(Integer.parseInt(cursor.getString(0)));
            perso.setLevel(Integer.parseInt(cursor.getString(1)));
            perso.setName(cursor.getString(2));
            perso.setSuccess((Integer.parseInt(cursor.getString(1))));
            // TOCOMPLETE //
            cursor.close();
        } else {
            perso = null;
        }
        db.close();
        return perso;
    }


}