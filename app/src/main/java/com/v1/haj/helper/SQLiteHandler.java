/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 */
package com.v1.haj.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "haj_db";

    // Login table name
    private static final String TABLE_USER = "user";

    // user Table Columns names
    private static final String KEY_U_ID = "user_id";
    private static final String KEY_U_Name = "name";
    private static final String KEY_U_Email = "email";
    private static final String KEY_U_Address = "address";
    private static final String KEY_U_USER_NAME = "username";
    private static final String KEY_U_PASSWORD = "password";
    private static final String KEY_U_TYPE = "type";


    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS `user` (" +
                "  " + KEY_U_ID + " int(11) DEFAULT NULL," +
                "  " + KEY_U_Name + " varchar(1000) DEFAULT NULL," +
                "  " + KEY_U_Email + " varchar(1000) DEFAULT NULL," +
                "  " + KEY_U_Address + " varchar(1000) DEFAULT NULL," +
                "  " + KEY_U_USER_NAME + " varchar(1000) NOT NULL," +
                "  " + KEY_U_PASSWORD + " varchar(1000) NOT NULL," +
                "  " + KEY_U_TYPE + " int(11) NOT NULL" +
                ");";
        db.execSQL(CREATE_USER_TABLE);


        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     */
    public void addUser(String user_id,
                        String name,
                        String email,
                        String address,
                        String user_name,
                        String password,
                        int type) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_U_ID, user_id);
        values.put(KEY_U_Name, name);
        values.put(KEY_U_Email, email);
        values.put(KEY_U_Address, address);
        values.put(KEY_U_USER_NAME, user_name);
        values.put(KEY_U_PASSWORD, password);
        values.put(KEY_U_TYPE, type);

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = null;
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user = new HashMap<String, String>();
            user.put("user_id", cursor.getString(0));
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("address", cursor.getString(3));
            user.put("user_name", cursor.getString(4));
            user.put("password", cursor.getString(5));
            user.put("type", cursor.getString(6));
        }
        cursor.close();
        db.close();
        // return user
//        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    /**
     * Recreate database Delete all tables and create them again
     */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all users info from sqlite");
    }

}
