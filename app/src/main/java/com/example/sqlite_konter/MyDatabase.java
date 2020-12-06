package com.example.sqlite_konter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_pulsa";
    private static final String tb_pulsa = "tb_pulsa";
    private static final String tb_kos_id = "id";
    private static final String tb_kos_nohp = "nohp";
    private static final String tb_kos_harga = "harga";
    private static final String tb_barang_jenis = "jenis";

    private static final String CREATE_TABLE_PULSA = "CREATE TABLE " +
            tb_pulsa + "("
            + tb_kos_id + " INTEGER PRIMARY KEY ,"
            + tb_kos_nohp + " TEXT,"
            + tb_kos_harga + " TEXT, "
            + tb_barang_jenis + " TEXT" + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PULSA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreatePulsa (Konter mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kos_id, mdNotif.get_id());
        values.put(tb_kos_nohp, mdNotif.get_nohp());
        values.put(tb_kos_harga, mdNotif.get_harga());
        values.put(tb_barang_jenis, mdNotif.get_jenis());
        db.insert(tb_pulsa, null, values);
        db.close();
    }
    public List<Konter> ReadPulsa() {
        List<Konter> judulModelList = new ArrayList<Konter>();
        String selectQuery = "SELECT * FROM " + tb_pulsa;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Konter mdKontak = new Konter();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nohp(cursor.getString(1));
                mdKontak.set_harga(cursor.getString(2));
                mdKontak.set_jenis(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdatePulsa (Konter mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kos_nohp, mdNotif.get_nohp());
        values.put(tb_kos_harga, mdNotif.get_harga());
        values.put(tb_barang_jenis, mdNotif.get_jenis());
        return db.update(tb_pulsa, values, tb_kos_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeletePulsa (Konter mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pulsa, tb_kos_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
