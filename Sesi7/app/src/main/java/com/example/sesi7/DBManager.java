package com.example.sesi7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c){
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void addContact(String name, String phone){
        ContentValues values = new ContentValues();
        values.put(DBHelper.FIELD_NAME, name);
        values.put(DBHelper.FIELD_PHONE, phone);

        database.insert(DBHelper.TABLE_CONTACT, null, values);
    }

    public ContactModel getContact(){
        String[] columns = new String[] {DBHelper.FIELD_ID, DBHelper.FIELD_NAME, DBHelper.FIELD_PHONE};
        Cursor cursor = database.query(DBHelper.TABLE_CONTACT, columns, null, null, null, null, null);

        if (cursor.moveToFirst()){
            ContactModel contactData = new ContactModel();
            contactData.setId(Integer.parseInt(cursor.getString(0)));
            contactData.setName(cursor.getString(1));
            contactData.setPhone(cursor.getString(2));

            return contactData;
        }

        return null;
    }

    public int updateContact(int id, String name, String phone){
        ContentValues values = new ContentValues();
        values.put(DBHelper.FIELD_NAME, name);
        values.put(DBHelper.FIELD_PHONE, phone);

        int result = database.update(DBHelper.TABLE_CONTACT, values, DBHelper.FIELD_ID + "=" + id, null);

        return result;
    }

    public void delete(int id){
        database.delete(DBHelper.TABLE_CONTACT, DBHelper.FIELD_ID + "=" + id, null);
    }
}
