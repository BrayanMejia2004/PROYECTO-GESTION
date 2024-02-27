package com.example.proyectogestion.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRegistroAsignatura extends DbGestion{

    Context context;

    public DbRegistroAsignatura(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaAsignatura(int codigoAsig, String nombreAsig, int creditoAsig){

        long id = 0;

        try {
        DbGestion dbGestion = new DbGestion(context);
        SQLiteDatabase db = dbGestion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("codigoAsig", codigoAsig);
        values.put("nombreAsig", nombreAsig);
        values.put("creditoAsig", creditoAsig);

        id = db.insert(TABLE_ASIGNATURA, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
