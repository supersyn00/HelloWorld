package com.example.itdev.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.itdev.helloworld._model.Login_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITDEV on 8/16/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    // database name
    private static final String DATABASE_NAME = "db_resto";
    // table name
    private static final String tbl_user = "tbl_user";
    // fields
    private static final String id = "id";
    private static final String username = "username";
    private static final String cpassword = "cpassword";
    private static final String fullname = "fullname";


    // query utk create table
    private static final String create_tbl_username = "CREATE TABLE " + tbl_user + "("
            + id + " INTEGER PRIMARY KEY, "
            + username + " TEXT, "
            + cpassword + " TEXT, "
            + fullname + " TEXT "
           +")";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_tbl_username);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // add data
    public void addNewUser(Login_model lm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(id, lm.get_UserID());
        cv.put(username, lm.get_NamaUser());
        cv.put(cpassword, lm.get_PassUser());
        cv.put(fullname, lm.get_NamaLengkap());

        db.insert(tbl_user, null, cv);
        Log.v("Row", "Data berhasil ditambah");
        db.close();
    }

    public List<Login_model> getAllData(){
        List<Login_model> UserList = new ArrayList<Login_model>();
        String qSelect = " Select * from " + tbl_user;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(qSelect, null);

        if(cursor.moveToFirst()){
            do {
                Login_model lm = new Login_model();
                lm.set_NamaUser(cursor.getString(1));
                lm.set_PassUser(cursor.getString(2));
                lm.set_NamaLengkap(cursor.getString(3));

            } while (cursor.moveToNext());
        }
        db.close();
        Log.v("Row", "Data view");
        return UserList;
    }
}
