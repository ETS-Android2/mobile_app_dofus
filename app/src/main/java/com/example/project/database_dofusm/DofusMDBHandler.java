package com.example.project.database_dofusm;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.project.appclasses.Job;
import com.example.project.appclasses.Personnage;
import com.example.project.enumdofusm.Classes;
import com.example.project.enumdofusm.JobEnum;
import com.example.project.enumdofusm.Servers;
import com.example.project.enumdofusm.Sex;

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

    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    // Table Names
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    private static final String TABLE_PERSO = "personnage";
    private static final String TABLE_CLASSE = "classe";
	private static final String TABLE_JOBNAME = "jobname";
	private static final String TABLE_SERVER = "server";
    private static final String TABLE_SEX = "sex";
    private static final String TABLE_CARAC = "carac";
    private static final String TABLE_JOB ="job";
    private static final String TABLE_JOB_PERSO = "job_perso";


    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    // Column name
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
 
    // PERSO Table - column names
    private static final String KEY_NAME = "name";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_SEX_ID= "sex_id";
	private static final String KEY_CLASSE_ID = "classe_id";
    private static final String KEY_SUCCESS = "success";
    private static final String KEY_CARAC_ID = "carac_id";
    private static final String KEY_SERVER_ID = "server_id";
    private static final String KEY_DESC = "descr";


 
    // CLASSE Table - column names
    private static final String KEY_CLASSE_NAME = "classe_name";

    // JOBNAME Table - column names
    private static final String KEY_JOBNAME_NAME = "job_name";

    // SERVER Table - column names
    private static final String KEY_SERVER_NAME = "server_name";

    // SEX Table - column names
    private static final String KEY_SEX_NAME = "sex_name";

    // CARAC Table - column names
    private static final String KEY_CARAC_STRENGTH = "strength";
    private static final String KEY_CARAC_AGILITY = "agility";
    private static final String KEY_CARAC_LUCK = "luck";
    private static final String KEY_CARAC_INT = "intelligence";

    // JOB Table - column names
    private static final String KEY_JOB_LEVEL = "job_level";
    private static final String KEY_JOBNAME_ID = "jobname_id";

    // JOB_PERSO Table
    private static final String KEY_PERSO_ID = "perso_id";
    private static final String KEY_JOB_ID = "job_id";

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    // Table Create Statements
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////


    // Perso table create statement
    private static final String CREATE_TABLE_PERSO = "CREATE TABLE "
            + TABLE_PERSO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT,"
			+ KEY_LEVEL + " INTEGER,"
            + KEY_SEX_ID + " INTEGER,"
            + KEY_CLASSE_ID + " INTEGER,"
			+ KEY_SUCCESS + " INTEGER,"
            + KEY_CARAC_ID + " INTEGER,"
            + KEY_SERVER_ID + " INTEGER,"
            + KEY_DESC + " TEXT,"
			+ KEY_CREATED_AT + " DATETIME" + ");";
 
    // Classe table create statement
    private static final String CREATE_TABLE_CLASSE = "CREATE TABLE " 
			+ TABLE_CLASSE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_CLASSE_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

	// Job table create statement
	private static final String CREATE_TABLE_JOBNAME = "CREATE TABLE "
            + TABLE_JOBNAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_JOBNAME_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Server table create statement
    private static final String CREATE_TABLE_SERVER = "CREATE TABLE "
            + TABLE_SERVER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_SERVER_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Sex table create statement
    private static final String CREATE_TABLE_SEX = "CREATE TABLE "
            + TABLE_SEX + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_SEX_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Carac table create statement
    private static final String CREATE_TABLE_CARAC = "CREATE TABLE "
            + TABLE_CARAC + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_CARAC_STRENGTH + " INTEGER,"
            + KEY_CARAC_AGILITY + " INTEGER,"
            + KEY_CARAC_LUCK + " INTEGER,"
            + KEY_CARAC_INT + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Job table create statement
    private static final String CREATE_TABLE_JOB = "CREATE TABLE "
            + TABLE_JOB + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_JOB_LEVEL + " INTEGER,"
            + KEY_JOBNAME_ID + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ");";

    // Job_Perso table create statement
    private static final String CREATE_TABLE_JOB_PERSO = "CREATE TABLE "
            + TABLE_JOB_PERSO + "(" + KEY_JOB_ID + " INTEGER,"
            + KEY_PERSO_ID + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ");";


    public DofusMDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required
        db.execSQL(CREATE_TABLE_JOB);
        db.execSQL(CREATE_TABLE_JOB_PERSO);
        db.execSQL(CREATE_TABLE_CARAC);
        db.execSQL(CREATE_TABLE_SEX);
        db.execSQL(CREATE_TABLE_SERVER);
        db.execSQL(CREATE_TABLE_JOBNAME);
        db.execSQL(CREATE_TABLE_CLASSE);
		db.execSQL(CREATE_TABLE_PERSO);

		addSex(db);
		addJobName(db);
		addClasse(db);
		addServer(db);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB_PERSO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARAC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEX);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBNAME);
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
            id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID)));
            cursor.close();
        } else {
            id = -1;
        }
        return id;
    }

    public long addPersoHandler(Personnage perso) {
        SQLiteDatabase db = this.getWritableDatabase();
        // for car
        ContentValues val = new ContentValues();
        val.put(KEY_CARAC_STRENGTH, perso.getCarac()[0]);
        val.put(KEY_CARAC_AGILITY, perso.getCarac()[1]);
        val.put(KEY_CARAC_LUCK, perso.getCarac()[2]);
        val.put(KEY_CARAC_INT, perso.getCarac()[3]);
        String carid = Long.toString(db.insert(TABLE_CARAC, null, val));


        for (Job j : perso.getJob()){
            ContentValues valjob = new ContentValues();
            valjob.put(KEY_JOBNAME_ID, findIdHandler(db, TABLE_JOBNAME, KEY_JOBNAME_NAME, j.getName().toString()));
            valjob.put(KEY_JOB_LEVEL, j.getLevel());
            String jobid = Long.toString(db.insert(TABLE_JOB, null, valjob));

            ContentValues valjobperso = new ContentValues();
            valjobperso.put(KEY_JOB_ID, jobid);
            valjobperso.put(KEY_PERSO_ID, perso.getId());
            db.insert(TABLE_JOB_PERSO, null, valjobperso);
        }


        ContentValues values = new ContentValues();
        values.put(KEY_NAME, perso.getName());
        values.put(KEY_LEVEL, perso.getLevel());
        values.put(KEY_SEX_ID,     findIdHandler(db, TABLE_SEX, KEY_SEX_NAME, perso.getSex().toString()));
        values.put(KEY_CLASSE_ID , findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));
        values.put(KEY_SUCCESS , perso.getSuccess());
        values.put(KEY_CARAC_ID, carid);
        values.put(KEY_SERVER_ID, findIdHandler(db, TABLE_SERVER, KEY_SERVER_NAME, perso.getServer().toString()));
        values.put(KEY_DESC, perso.getDesc());
        values.put(KEY_CREATED_AT, getDateTime());
        // insert row
        long _id = db.insert(TABLE_PERSO, null, values);
        db.close();
        return _id;
    }

    public boolean updatePersoHandler(Personnage perso) {
        SQLiteDatabase db = this.getWritableDatabase();
        // for car
        ContentValues val = new ContentValues();
        val.put(KEY_CARAC_STRENGTH, perso.getCarac()[0]);
        val.put(KEY_CARAC_AGILITY, perso.getCarac()[1]);
        val.put(KEY_CARAC_LUCK, perso.getCarac()[2]);
        val.put(KEY_CARAC_INT, perso.getCarac()[3]);
        String carid = Long.toString(db.insert(TABLE_CARAC, null, val));


        for (Job j : perso.getJob()){
            ContentValues valjob = new ContentValues();
            valjob.put(KEY_JOBNAME_ID, findIdHandler(db, TABLE_JOBNAME, KEY_JOBNAME_NAME, j.getName().toString()));
            valjob.put(KEY_JOB_LEVEL, j.getLevel());
            String jobid = Long.toString(db.insert(TABLE_JOB, null, valjob));

            ContentValues valjobperso = new ContentValues();
            valjobperso.put(KEY_JOB_ID, jobid);
            valjobperso.put(KEY_PERSO_ID, perso.getId());
            db.insert(TABLE_JOB_PERSO, null, valjobperso);
        }

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, perso.getName());
        values.put(KEY_LEVEL, perso.getLevel());
        values.put(KEY_SEX_ID, perso.getSex().toString());
        values.put(KEY_CLASSE_ID , findIdHandler(db, TABLE_CLASSE, KEY_CLASSE_NAME, perso.getCla().toString()));
        values.put(KEY_SUCCESS , perso.getSuccess());
        values.put(KEY_CARAC_ID, carid);
        values.put(KEY_SERVER_ID, findIdHandler(db, TABLE_SERVER, KEY_SERVER_NAME, perso.getServer().toString()));
        values.put(KEY_DESC, perso.getDesc());
        values.put(KEY_CREATED_AT, getDateTime());

        String where = KEY_ID + "=?";
        String[] whereargs = new String[] { Integer.toString(perso.getId()) };

        return db.update(TABLE_PERSO, values, where ,whereargs) > 0;
    }

    public List<String> getPersName(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select "+ KEY_NAME+", "+ KEY_LEVEL +", "+ KEY_CLASSE_NAME + " FROM " + TABLE_PERSO +" a INNER JOIN " +TABLE_CLASSE +" b ON a."+ KEY_CLASSE_ID+" = b."+KEY_ID;
        Cursor cursor = db.rawQuery(query, null);
        List<String> u = new ArrayList<String>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            u.add(cursor.getString(cursor.getColumnIndex(KEY_NAME))+"   -   NIVEAU "+cursor.getString(cursor.getColumnIndex(KEY_LEVEL))+"    -    CLASSE : "+cursor.getString(cursor.getColumnIndex(KEY_CLASSE_NAME)));
        }
        cursor.close();
        return u;
    }

    public List<String> getSexHandler(){
        return getListAttrHandler(KEY_SEX_NAME, TABLE_SEX); }

    public List<String> getClassHandler(){
        return getListAttrHandler(KEY_CLASSE_NAME, TABLE_CLASSE);
    }

    public List<String> getServHandler(){
        return getListAttrHandler(KEY_SERVER_NAME, TABLE_SERVER);
    }

    public List<String> getListAttrHandler(String attr, String table){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select "+ attr+ " FROM " + table;
        Cursor cursor = db.rawQuery(query, null);
        List<String> u = new ArrayList<String>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            u.add(cursor.getString(cursor.getColumnIndex(attr)));
        }
        cursor.close();
        db.close();
        return u;
    }


    public boolean deletePersoHandler(int ID) {
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        int a;


        String query = "Select "+ KEY_JOB_ID +" FROM " + TABLE_JOB_PERSO + " WHERE " + KEY_PERSO_ID + "= '" + ID + "'";
        Cursor cursor = db.rawQuery(query, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            a = Integer.parseInt(cursor.getString(0));
            db.delete(TABLE_JOB, KEY_ID + "=?",
                    new String[] {
                            String.valueOf(a)
                    });
        }
        cursor.close();

        query = "Select "+ KEY_CARAC_ID +" FROM " + TABLE_PERSO + " WHERE " + KEY_PERSO_ID + "= '" + ID + "'";
        cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            a = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_CARAC_ID)));
            db.delete(TABLE_CARAC, KEY_ID + "=?",
                    new String[] {
                            String.valueOf(a)
                    });
        }
        cursor.close();

        query = "Select * FROM " + TABLE_PERSO + " WHERE " + KEY_ID + "= '" + ID + "'";
        cursor = db.rawQuery(query, null);
        Personnage perso = new Personnage();
        if (cursor.moveToFirst()) {
            Integer.parseInt(cursor.getString(0));
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

    public int[] retrievecarac(SQLiteDatabase db, int id){
        String query = "Select * FROM " + TABLE_CARAC + " WHERE " + KEY_ID + " = " + "'" + id + "'";
        Cursor cursor = db.rawQuery(query, null);
        int[] car = new int[4];
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            car[0] = Integer.parseInt(cursor.getString(1));
            cursor.close();
        }
        return car;
    }

    public Job[] retrieveJobs(SQLiteDatabase db, int id){



        String query = "Select "+ KEY_JOB_LEVEL +", "+ KEY_JOBNAME_NAME +" FROM ( " + TABLE_JOB_PERSO + " a INNER JOIN "+TABLE_JOB+" b ON a." +KEY_JOB_ID+ " = b."+KEY_ID+" ) c INNER JOIN "+TABLE_JOBNAME+" d ON c." + KEY_JOBNAME_ID + " = d."+KEY_ID+" WHERE " + KEY_PERSO_ID + "= '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);
        List<Job> jo = new ArrayList<Job>();

        Log.v(LOG, query);


        // todo
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            jo.add(new Job( JobEnum.valueOf(  cursor.getString(cursor.getColumnIndex(KEY_JOBNAME_NAME)) ), Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_JOB_LEVEL)))));
        }
        cursor.close();
        Job[] a = new Job[jo.size()];
        a = jo.toArray(a);
        Log.v(LOG, a.toString());
        return a;
    }

    public Personnage findPersoHandler(String perso_id) {
        String query = "Select * FROM " + TABLE_PERSO + " WHERE " + KEY_ID + " = " + "'" + perso_id + "'";

        Log.v("attrclassquer",query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Personnage perso = new Personnage();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            perso.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
            perso.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            perso.setLevel(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_LEVEL))));
            perso.setSex( Sex.valueOf( getAttrName(   db,TABLE_SEX, KEY_ID,    Integer.parseInt(           cursor.getString(cursor.getColumnIndex(KEY_SEX_ID)))).trim() ));
            perso.setCla( Classes.valueOf(  getAttrName(db,TABLE_CLASSE, KEY_ID, Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_CLASSE_ID)))).trim()   ) );
            perso.setSuccess(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_SUCCESS))));
            perso.setJob(retrieveJobs(db,perso.getId()));
            perso.setCarac(retrievecarac(db,Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_CARAC_ID)) )));
            perso.setServer( Servers.valueOf(  getAttrName(db,TABLE_SERVER, KEY_ID, Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_SERVER_ID)))).trim()   ) );
            perso.setDesc(cursor.getString(cursor.getColumnIndex(KEY_DESC)));

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

    public boolean addJobName(SQLiteDatabase db) {
        ContentValues values;
        boolean job_initialized = false;
        long job_id;
        for (JobEnum cla : JobEnum.values()) {
            values = new ContentValues();
            values.put(KEY_JOBNAME_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            job_id = db.insert(TABLE_JOBNAME, null, values);
            job_initialized = true;
        }
        return job_initialized;
    }

    public boolean addServer(SQLiteDatabase db) {
        ContentValues values;
        boolean server_initialized = false;
        long server_id;
        for (Servers cla : Servers.values()) {
            values = new ContentValues();
            values.put(KEY_SERVER_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            server_id = db.insert(TABLE_SERVER, null, values);
            server_initialized = true;
        }
        return server_initialized;
    }

    public boolean addSex(SQLiteDatabase db) {
        ContentValues values;
        boolean sex_initialized = false;
        long sex_id;
        for (Sex cla : Sex.values()) {
            values = new ContentValues();
            values.put(KEY_SEX_NAME, cla.toString());
            values.put(KEY_CREATED_AT, getDateTime());
            // insert row
            sex_id = db.insert(TABLE_SEX, null, values);
            sex_initialized = true;
        }
        return sex_initialized;
    }

    ////// other

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}