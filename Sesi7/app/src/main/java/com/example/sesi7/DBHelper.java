package com.example.sesi7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Contact.db";
    public static final String TABLE_CONTACT = "contacts";
    public static final String FIELD_NAME = "contact_name";
    public static final String FIELD_PHONE = "contact_phone";
    public static final String FIELD_ID = "contact_id";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_CONTACT + "("
                + FIELD_ID + " INTEGER PRIMARY KEY,"
                + FIELD_NAME + " TEXT,"
                + FIELD_PHONE + " TEXT)";

        // query = "CREATE TABLE contacts(id INTEGER PRIMARY KEY, contact_name TEXT, contact_phone TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }
}
