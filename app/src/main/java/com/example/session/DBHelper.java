package com.example.session;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "login.db";
    private static final String TABLE_NAME = "login_table";
    private static final String COL_ID = "ID";
    private static final String COL_LOGIN = "LOGIN";
    private static final String COL_PASSWORD = "PASSWORD";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_LOGIN + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addLoginData(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();//новые данные
        contentValues.put(COL_LOGIN, login);
        contentValues.put(COL_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

}