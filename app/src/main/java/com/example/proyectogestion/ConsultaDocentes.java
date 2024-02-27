package com.example.proyectogestion;

import static com.example.proyectogestion.BaseDatos.DbGestion.TABLE_DOCENTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbGestion;

public class ConsultaDocentes extends AppCompatActivity {

    EditText txtConsultaDocumentoDocente;
    EditText txtConsultaNombreDocente;
    EditText txtConsultaApellidoDocente;
    EditText txtConsultaFechaDocente;
    EditText txtConsultaProfesionDocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_docentes);

        txtConsultaDocumentoDocente = findViewById(R.id.txtConsultaDocumentoDocente);
        txtConsultaNombreDocente = findViewById(R.id.txtConsultaNombreDocente);
        txtConsultaApellidoDocente = findViewById(R.id.txtConsultaApellidoDocente);
        txtConsultaFechaDocente = findViewById(R.id.txtConsultaFechaDocente);
        txtConsultaProfesionDocente = findViewById(R.id.txtConsultaProfesionDocente);
    }

    public void BuscarDocente(View view){

        DbGestion dbGestion = new DbGestion(ConsultaDocentes.this, "Gestiondb", null, 4);
        SQLiteDatabase db = dbGestion.getReadableDatabase();

        String documento = txtConsultaDocumentoDocente.getText().toString();

        if (!documento.isEmpty()){

            Cursor fila = db.rawQuery("SELECT nombre,apellido,fecha,profesion FROM t_docente WHERE documento=" + documento, null);

            if (fila.moveToFirst()){
                txtConsultaNombreDocente.setText(fila.getString(0));
                txtConsultaApellidoDocente.setText(fila.getString(1));
                txtConsultaFechaDocente.setText(fila.getString(2));
                txtConsultaProfesionDocente.setText(fila.getString(3));
                db.close();

            }else {
                Toast.makeText(ConsultaDocentes.this, "NO SE ENCUENTRA NINGUN DOCENTE", Toast.LENGTH_SHORT).show();
                limipar();
                db.close();
            }

        }else {
            Toast.makeText(ConsultaDocentes.this, "DEBES INGRESAR EL DOCUMENTO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limipar(){
        txtConsultaNombreDocente.setText("");
        txtConsultaApellidoDocente.setText("");
        txtConsultaFechaDocente.setText("");
        txtConsultaProfesionDocente.setText("");

    }
}