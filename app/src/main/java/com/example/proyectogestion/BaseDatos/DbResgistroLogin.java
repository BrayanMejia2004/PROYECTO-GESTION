package com.example.proyectogestion.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;

import androidx.annotation.Nullable;

public class DbResgistroLogin extends DbGestion{

    Context context;
    public DbResgistroLogin(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarRegistroLogin(String nombre, String correo, String contraseña){

        long id = 0;

        try {
            DbGestion dbGestion = new DbGestion(context);
            SQLiteDatabase db = dbGestion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("correo", correo);
            values.put("contraseña", contraseña);

            id = db.insert(TABLE_LOGIN, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
