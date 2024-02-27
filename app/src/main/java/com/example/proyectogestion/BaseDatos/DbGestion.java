package com.example.proyectogestion.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.proyectogestion.MainActivity;

import javax.xml.transform.sax.TemplatesHandler;

public class DbGestion extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NOMBRE = "Gestiondb";
    public static final String TABLE_LOGIN = "t_login";
    public static final String TABLE_DOCENTE = "t_docente";
    public static final String TABLE_ESTUDIANTE = "t_estudiante";
    public static final String TABLE_ASIGNATURA = "t_asignatura";
    public static final String TABLE_MATRICULA = "t_matricula";


    public DbGestion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbGestion(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_LOGIN + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "correo TEXT NOT NULL," +
                "contraseña TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DOCENTE + "("+
                "documento INTEGER PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "profesion TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ESTUDIANTE + "("+
                "documento INTEGER PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "telefono INTEGER NOT NULL," +
                "correo TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ASIGNATURA + "("+
                "codigoAsig INTEGER PRIMARY KEY," +
                "nombreAsig TEXT NOT NULL," +
                "creditoAsig INTEGER NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MATRICULA + "("+
                "codigoAsig INTEGER NOT NULL," +
                "documento INTEGER NOT NULL," +
                "grupo INTEGER NOT NULL," +
                "jornada TEXT NOT NULL," +
                "programaAcademica TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_LOGIN);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DOCENTE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ESTUDIANTE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ASIGNATURA);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MATRICULA);
        onCreate(sqLiteDatabase);
    }
}
