package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbGestion;

public class ConsultaEstudiantes extends AppCompatActivity {

    EditText txtConsultaDocumentoEst;
    EditText txtConsultaNombreEst;
    EditText txtConsultaApellidoEst;
    EditText txtConsultaTelefonoEst;
    EditText txtConsultaCorreoEst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_estudiantes);

            txtConsultaDocumentoEst = findViewById(R.id.txtConsultaDocumentoEst);
            txtConsultaNombreEst = findViewById(R.id.txtConsultaNombreEst);
            txtConsultaApellidoEst = findViewById(R.id.txtConsultaApellidoEst);
            txtConsultaTelefonoEst = findViewById(R.id.txtConsultaTelefonoEst);
            txtConsultaCorreoEst = findViewById(R.id.txtConsultaCorreoEst);
    }

    public void BuscarEstudiante(View view){

        DbGestion dbGestion = new DbGestion(ConsultaEstudiantes.this, "Gestiondb", null, 4);
        SQLiteDatabase db = dbGestion.getReadableDatabase();

        String documento = txtConsultaDocumentoEst.getText().toString();

        if (!documento.isEmpty()){

            Cursor fila = db.rawQuery("SELECT nombre,apellido,fecha,telefono,correo FROM t_estudiante WHERE documento=" + documento, null);

            if (fila.moveToFirst()){
                txtConsultaNombreEst.setText(fila.getString(0));
                txtConsultaApellidoEst.setText(fila.getString(1));
                txtConsultaTelefonoEst.setText(fila.getString(3));
                txtConsultaCorreoEst.setText(fila.getString(4));
                db.close();

            }else {
                Toast.makeText(ConsultaEstudiantes.this, "NO SE ENCUENTRA NINGUN ESTUDIANTE", Toast.LENGTH_SHORT).show();
                limipar();
                db.close();
            }

        }else {
            Toast.makeText(ConsultaEstudiantes.this, "DEBES INGRESAR EL DOCUMENTO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limipar(){
        txtConsultaNombreEst.setText("");
        txtConsultaApellidoEst.setText("");
        txtConsultaTelefonoEst.setText("");
        txtConsultaCorreoEst.setText("");

    }
}