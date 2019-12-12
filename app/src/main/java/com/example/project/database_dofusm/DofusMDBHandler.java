package com.example.project.database_dofusm;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.project.appclasses.Job;
import com.example.project.appclasses.Personnage;
import com.example.project.appclasses.Equipement;
import com.example.project.enumdofusm.Align;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.ItemType;
import com.example.project.enumdofusm.JobEnum;
import com.example.project.enumdofusm.WeaponType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	private static final String TABLE_EQUIPEMENT = "equipement";
    private static final String TABLE_WEAPONTYPE = "weapontype";
    private static final String TABLE_ITEMTYPE = "itemtype";
 
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
    private static final String KEY_JOB_LEVEL = "job_level";
    private static final String KEY_EQUIPEMENT_ID = "equipement_id";
 
    // CLASSE Table - column names
    private static final String KEY_CLASSE_NAME = "classe_name";
 
    // ALIGNEMENT Table - column names
    private static final String KEY_ALIGNEMENT_NAME = "alignement_name";

    // JOB Table - column names
    private static final String KEY_JOB_NAME = "job_name";

    // WEAPONTYPE Table - column names
    private static final String KEY_WEAPONTYPE_NAME = "weapontype_name";

    // ITEMTYPE Table - column names
    private static final String KEY_ITEMTYPE_NAME = "itemtype_name";
	
	// EQUIPEMENT Table - column names
    //private static final String KEY_EQUIPEMENT_ = "jobname_name";
 
    // Table Create Statements
    // Perso table create statement
    private static final String CREATE_TABLE_PERSO = "CREATE TABLE "
            + TABLE_PERSO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_LEVEL + " INTEGER,"
			+ KEY_NAME + " TEXT,"
			+ KEY_SUCCESS + " INTEGER,"
			+ KEY_KOLIZEUM + " INTEGER,"
			+ KEY_CLASSE_ID + " INTEGER,"
			+ KEY_ALIGNEMENT_ID + " INTEGER,"
			+ KEY_JOB_ID + " INTEGER,"
            + KEY_JOB_LEVEL + " INTEGER,"
			+ KEY_EQUIPEMENT_ID + " INTEGER,"
			+ KEY_CREATED_AT + " DATETIME" + ");";
 
    // Classe table create statement
    private static final String CREATE_TABLE_CLASSE = "CREATE TABLE " 
			+ TABLE_CLASSE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_CLASSE_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";
 
    // Alignement table create statement
    private static final String CREATE_TABLE_ALIGNEMENT = "CREATE TABLE "
            + TABLE_ALIGNEMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_ALIGNEMENT_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Weapontype table create statement
    private static final String CREATE_TABLE_WEAPONTYPE = "CREATE TABLE "
            + TABLE_WEAPONTYPE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_WEAPONTYPE_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Itemtype table create statement
    private static final String CREATE_TABLE_ITEMTYPE = "CREATE TABLE "
            + TABLE_ITEMTYPE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_ITEMTYPE_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

	// Job table create statement
	private static final String CREATE_TABLE_JOB = "CREATE TABLE "
            + TABLE_JOB + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_JOB_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";
			
	// Equipement table create statement
	private static final String CREATE_TABLE_EQUIPEMENT = "CREATE TABLE "
            + TABLE_EQUIPEMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			
            + KEY_CREATED_AT + " DATETIME" + ");";
 
    public DofusMDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_WEAPONTYPE);
        db.execSQL(CREATE_TABLE_JOB);
        db.execSQL(CREATE_TABLE_EQUIPEMENT);
		db.execSQL(CREATE_TABLE_ALIGNEMENT);
        db.execSQL(CREATE_TABLE_CLASSE);
		db.execSQL(CREATE_TABLE_PERSO);
		db.execSQL(CREATE_TABLE_ITEMTYPE);

		addJob(db);
		addAlign(db);
		addClasse(db);
        addWeaponType(db);
        addItemType(db);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMTYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPONTYPE);
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

    public void dropH(int i, int j){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db, i, j);
    }

    public int findIdHandler(SQLiteDatabase db, String TABLE_NAME, String COLUMN_NAME, String name){

        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = " + "'" + name + "'";
        Cursor cursor = db.rawQuery(query, null);
        int id;
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            id = Integer.parseInt(cursor.getString(0));
            cursor.close();
        } else {
            id = -1;
        }
        return id;
    }

    public long addPersoHandler(Personnage perso) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LEVEL, perso.getLevel());
        values.put(KEY_NAME, perso.getName());
        values.put(KEY_SUCCESS , perso.getSuccess());
        values.put(KEY_KOLIZEUM , perso.getKolizeum());
        values.put(KEY_CLASSE_ID , findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));
        values.put(KEY_ALIGNEMENT_ID, findIdHandler(db, TABLE_ALIGNEMENT, KEY_ALIGNEMENT_NAME, perso.getAl().toString()));
        values.put(KEY_JOB_ID, findIdHandler(db, TABLE_JOB, KEY_JOB_NAME, perso.getJob().getName().toString()));
        values.put(KEY_JOB_LEVEL, perso.getJob().getLevel());

        //values.put(KEY_EQUIPEMENT_ID, findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));
        values.put(KEY_CREATED_AT, getDateTime());


        // insert row
        long _id = db.insert(TABLE_PERSO, null, values);
        db.close();

        return _id;

    }

    public List<String> getPersName(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select "+ KEY_NAME + " FROM " + TABLE_PERSO;
        Cursor cursor = db.rawQuery(query, null);
        Log.v("u", query);
        List<String> u = new ArrayList<String>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            u.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        }
        cursor.close();
        return u;

    }

    public boolean updatePersoHandler(Personnage perso) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, perso.getId());
        values.put(KEY_NAME, perso.getName());
        values.put(KEY_SUCCESS , perso.getSuccess());
        values.put(KEY_KOLIZEUM , perso.getKolizeum());
        values.put(KEY_CLASSE_ID , findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));
        values.put(KEY_ALIGNEMENT_ID, findIdHandler(db, TABLE_ALIGNEMENT, KEY_ALIGNEMENT_NAME, perso.getCla().toString()));
        values.put(KEY_JOB_ID, findIdHandler(db, TABLE_JOB, KEY_JOB_NAME, perso.getJob().getName().toString()));
        values.put(KEY_JOB_LEVEL, perso.getJob().getLevel());


        // values.put(KEY_EQUIPEMENT_ID, findIdHandler(db, TABLE_EQUIPEMENT, KEY_EQUIPEMENT_ID, perso.getCla().toString()));
        values.put(KEY_CREATED_AT, getDateTime());

        String where = KEY_ID + "=?";
        String[] whereargs = new String[] { Integer.toString(perso.getId()) };

        return db.update(KEY_NAME, values, where ,whereargs) > 0;
    }

    public boolean deletePersoHandler(int ID) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_PERSO + " WHERE " + KEY_ID + "= '" + ID + "'";
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

    public String getAttrName(SQLiteDatabase db, String TABLE_NAME, String COLUMN_NAME, int id){

        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = " + "'" + id + "'";
        Cursor cursor = db.rawQuery(query, null);
        String name;
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            name = cursor.getString(1);
            cursor.close();
        } else {
            name = "";
        }
        return name;
    }

    public Personnage findPersoHandler(String perso_id) {
        String query = "Select * FROM " + TABLE_PERSO + " WHERE " + KEY_ID + " = " + "'" + perso_id + "'";

        Log.v("attrclassquer",query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Personnage perso = new Personnage();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            perso.setId(Integer.parseInt(cursor.getString(0)));
            perso.setLevel(Integer.parseInt(cursor.getString(1)));
            perso.setName(cursor.getString(2));
            perso.setSuccess(Integer.parseInt(cursor.getString(3)));
            perso.setKolizeum(Integer.parseInt(cursor.getString(4)));
            perso.setCla(   Classes.valueOf(  getAttrName(db,TABLE_CLASSE, KEY_ID, Integer.parseInt(cursor.getString(5))).trim()   ) );
            perso.setAl(    Align.valueOf(    getAttrName(db,TABLE_ALIGNEMENT, KEY_ID, Integer.parseInt(cursor.getString(6)))          ) );
            perso.setJob(new Job(JobEnum.valueOf(getAttrName(db,TABLE_JOB, KEY_ID, Integer.parseInt(cursor.getString(7)))), Integer.parseInt(cursor.getString(8) )));


           // values.put(KEY_EQUIPEMENT_ID, findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));

            // TODO //
            cursor.close();
        } else {
            perso = null;
        }
        db.close();
        return perso;
    }


    /// init
    public boolean addClasse(SQLiteDatabase db) {
        ContentValues values;
        boolean classe_initialized = false;
        long classe_id;
        for (Classes cla : Classes.values()) {
            values = new ContentValues();
            values.put(KEY_CLASSE_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            classe_id = db.insert(TABLE_CLASSE, null, values);
            classe_initialized = true;
        }
        return classe_initialized;
    }

    public boolean addAlign(SQLiteDatabase db) {
        ContentValues values;
        boolean align_initialized = false;
        long align_id;
        for (Align cla : Align.values()) {
            values = new ContentValues();
            values.put(KEY_ALIGNEMENT_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            align_id = db.insert(TABLE_ALIGNEMENT, null, values);
            align_initialized = true;
        }
        return align_initialized;
    }

    public boolean addJob(SQLiteDatabase db) {
        ContentValues values;
        boolean job_initialized = false;
        long job_id;
        for (JobEnum cla : JobEnum.values()) {
            values = new ContentValues();
            values.put(KEY_JOB_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            job_id = db.insert(TABLE_JOB, null, values);
            job_initialized = true;
        }
        return job_initialized;
    }

    public boolean addWeaponType(SQLiteDatabase db) {
        ContentValues values;
        boolean job_initialized = false;
        long job_id;
        for (WeaponType cla : WeaponType.values()) {
            values = new ContentValues();
            values.put(KEY_WEAPONTYPE_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            job_id = db.insert(TABLE_WEAPONTYPE, null, values);
            job_initialized = true;
        }
        return job_initialized;
    }

    public boolean addItemType(SQLiteDatabase db) {
        ContentValues values;
        boolean job_initialized = false;
        long job_id;
        for (ItemType cla : ItemType.values()) {
            values = new ContentValues();
            values.put(KEY_ITEMTYPE_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            job_id = db.insert(TABLE_ITEMTYPE, null, values);
            job_initialized = true;
        }
        return job_initialized;
    }



    ////// other

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}