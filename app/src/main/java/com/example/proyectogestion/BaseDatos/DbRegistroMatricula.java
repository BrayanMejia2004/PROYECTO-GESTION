package com.example.proyectogestion.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRegistroMatricula extends DbGestion{

    Context context;

    public DbRegistroMatricula(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaMatricula(int codigoAsig, int documento, int grupo, String jornada, String programaAcademica){

        long id = 0;

        try{
            DbGestion dbGestion = new DbGestion(context);
            SQLiteDatabase db = dbGestion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("codigoAsig", codigoAsig);
            values.put("documento", documento);
            values.put("grupo", grupo);
            values.put("jornada", jornada);
            values.put("programaAcademica", programaAcademica);

            id = db.insert(TABLE_MATRICULA, null, values);
        }catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}
