package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.proyectogestion.BaseDatos.DbGestion;

public class ListaDocentes extends AppCompatActivity {

    TableLayout tlDocentes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_docentes);

        tlDocentes = findViewById(R.id.tlDocentes);
        llenarTablaDocente();
    }

    public void llenarTablaDocente(){

        DbGestion dbGestion = new DbGestion(ListaDocentes.this);
        SQLiteDatabase db = dbGestion.getWritableDatabase();

        Cursor cursor = null ;
        cursor = db.rawQuery(" SELECT * FROM " + DbGestion.TABLE_DOCENTE, null);
        cursor.moveToFirst();

        do {

            View registro = LayoutInflater.from(this).inflate(R.layout.item_docentes, null,false);

            TextView viewDocumento = findViewById(R.id.viewDocumento);
            TextView viewNombre = findViewById(R.id.viewNombre);
            TextView viewApellido = findViewById(R.id.viewApellido);
            TextView viewFecha = findViewById(R.id.viewFecha);
            TextView ViewProfesion = findViewById(R.id.viewProfesion);

            viewDocumento.setText(cursor.getString(0));
            viewNombre.setText(cursor.getString(1));
            viewApellido.setText(cursor.getString(2));
            viewFecha.setText(cursor.getString(3));
            ViewProfesion.setText(cursor.getString(4));

            tlDocentes.addView(registro);

        }while (cursor.moveToNext());
        cursor.close();
    }
}