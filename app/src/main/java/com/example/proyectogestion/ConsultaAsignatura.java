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

public class ConsultaAsignatura extends AppCompatActivity {

    EditText txtConsultaCodigoAsig;
    EditText txtConsultaCodigo1Asig;
    EditText txtConsultaNombreAsig;
    EditText txtConsultaCreditoAsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_asignatura);

        txtConsultaCodigoAsig = findViewById(R.id.txtConsultaCodigoAsig);
        txtConsultaCodigo1Asig = findViewById(R.id.txtConsultaCodigo1Asig);
        txtConsultaNombreAsig = findViewById(R.id.txtConsultaNombreAsig);
        txtConsultaCreditoAsig = findViewById(R.id.txtConsultaCreditoAsig);

    }

    public void BuscarAsignatura(View view) {
        DbGestion dbGestion = new DbGestion(ConsultaAsignatura.this, "Gestiondb", null, 4);
        SQLiteDatabase db = dbGestion.getReadableDatabase();

        String codigoAsig = txtConsultaCodigoAsig.getText().toString();

        if (!codigoAsig.isEmpty()) {

            Cursor fila = db.rawQuery("SELECT codigoAsig, nombreAsig, creditoAsig FROM t_asignatura WHERE codigoAsig=" + codigoAsig, null);

            if (fila.moveToFirst()) {
                txtConsultaCodigo1Asig.setText(fila.getString(0));
                txtConsultaNombreAsig.setText(fila.getString(1));
                txtConsultaCreditoAsig.setText(fila.getString(2));
                db.close();

            } else {
                Toast.makeText(ConsultaAsignatura.this, "NO SE ENCUENTRA NINGUNA ASIGNATURA", Toast.LENGTH_SHORT).show();
                limpiar();
                db.close();
            }
        } else {
            Toast.makeText(ConsultaAsignatura.this, "DEBE INGRESAR EL CODIGO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        txtConsultaCodigo1Asig.setText("");
        txtConsultaNombreAsig.setText("");
        txtConsultaCreditoAsig.setText("");
    }
}