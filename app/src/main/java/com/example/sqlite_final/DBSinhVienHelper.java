package com.example.sqlite_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptIntrinsicHistogram;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBSinhVienHelper extends SQLiteOpenHelper {
    public static final String DB_NAME =" sinhvien.db";
    public DBSinhVienHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SinhVien.TAO_BANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SinhVien.XOA_BANG);
        onCreate(db);
    }

    public Integer xoaSV(String mssv){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = SinhVien.COL_MSSV + " =?";
        String[] where = {mssv};

        Integer flag = sqLiteDatabase.delete(
                SinhVien.TABLE_NAME,
                selection,
                where
        );

        return flag;
    }

    public Integer capNhatSV(SinhVien sv){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SinhVien.COL_MSSV, sv.getMSSV());
        values.put(SinhVien.COL_HOTEN, sv.getHoTen());
        values.put(SinhVien.COL_DIEMTK, sv.getDiemTK());

        String selection = SinhVien.COL_MSSV + " =?";
        String[] where ={sv.getMSSV()};

        Integer flag = sqLiteDatabase.update(
                SinhVien.TABLE_NAME,
                values,
                selection,
                where
        );

        return flag;
    }

    public SinhVien timKiem(String mssv){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] projection = {
                SinhVien.COL_MSSV,
                SinhVien.COL_HOTEN,
                SinhVien.COL_DIEMTK
        };

        String selection = SinhVien.COL_MSSV + " =?";
        String[] where = {mssv};

        Cursor cursor = sqLiteDatabase.query(
                SinhVien.TABLE_NAME,
                projection,
                selection,
                where,
                null,
                null,
                null
        );
        SinhVien sv = null;
        while(cursor.moveToNext()){
            String hoten = cursor.getString(cursor.getColumnIndexOrThrow(SinhVien.COL_HOTEN));
            Float diemtk = cursor.getFloat(cursor.getColumnIndexOrThrow(SinhVien.COL_DIEMTK));
            sv = new SinhVien(mssv,hoten,diemtk);
        };
        cursor.close();
        return sv;
    }

    public long addSV(SinhVien sv){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SinhVien.COL_MSSV, sv.getMSSV());
        values.put(SinhVien.COL_HOTEN, sv.getHoTen());
        values.put(SinhVien.COL_DIEMTK, sv.getDiemTK());

        long insert = sqLiteDatabase.insert(SinhVien.TABLE_NAME, null,values);
        return insert;
    }

    public LinkedList<SinhVien> DSSV(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] projection = {
                SinhVien.COL_MSSV,
                SinhVien.COL_HOTEN,
                SinhVien.COL_DIEMTK
        };

        Cursor cursor = sqLiteDatabase.query(
                SinhVien.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        LinkedList<SinhVien> listSV = new LinkedList<>();

        while(cursor.moveToNext()){
            String mssv = cursor.getString(cursor.getColumnIndexOrThrow(SinhVien.COL_MSSV));
            String hoten = cursor.getString(cursor.getColumnIndexOrThrow(SinhVien.COL_HOTEN));
            float diemtk = cursor.getFloat(cursor.getColumnIndexOrThrow(SinhVien.COL_DIEMTK));
            SinhVien sv = new SinhVien(mssv, hoten, diemtk);
            listSV.addLast(sv);
        }
        cursor.close();
        return listSV;
    }
}
