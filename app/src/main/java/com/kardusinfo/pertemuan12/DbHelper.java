package com.kardusinfo.pertemuan12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_STD = "students";
    public static final String KEY_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_NIM = "nim";
    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STD + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAMA + " TEXT, " + KEY_NIM + " TEXT );";
    public static String DATABASE_NAME = "dbsiakad";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STD + "'");
    }

    public long addUserDetail(String nim, String nama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, nama);
        values.put(KEY_NIM, nim);
        return db.insert(TABLE_STD, null, values);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        String selectQuery = "SELECT *FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                student.setNim(cursor.getString(cursor.getColumnIndex(KEY_NIM)));
                student.setNama(cursor.getString(cursor.getColumnIndex(KEY_NAMA)));
                students.add(student);
            } while (cursor.moveToNext());
        }
        return students;
    }
}
