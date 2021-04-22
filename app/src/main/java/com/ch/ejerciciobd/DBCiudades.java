package com.ch.ejerciciobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBCiudades extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "bdCiudades.db";

    public DBCiudades(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ciudad(id INTEGER PRIMARY KEY,nombre TEXT, latitud REAL,longitud REAL, poblacion INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ciudad");
        onCreate(db);
    }

    public void agregarCiudad(SQLiteDatabase db, Ciudad mCiudad) {
        ContentValues values = new ContentValues();
        values.put("id", mCiudad.getId());
        values.put("nombre", mCiudad.getNombre());
        values.put("latitud", mCiudad.getLatitud());
        values.put("longitud", mCiudad.getLongitud());
        values.put("poblacion", mCiudad.getPoblacion());
        //Guarda la ciudad en la tabla
        db.insert("ciudad", null, values);
    }

    public ArrayList<Ciudad> seleccionarCiudad(SQLiteDatabase db) {
        ArrayList<Ciudad> lCiudades = new ArrayList<Ciudad>();
        Cursor filas = db.rawQuery("select * from ciudad", null);
        if (filas.moveToFirst()) {
            do {
                Ciudad ciudad = new Ciudad(filas.getInt(0), filas.getString(1), filas.getDouble(2),
                        filas.getDouble(3), filas.getInt(4));
                lCiudades.add(ciudad);
            } while (filas.moveToNext());
        }
        return lCiudades;
    }
}
