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

public class ConsultaMatricula extends AppCompatActivity {

    EditText txtConsultaDocumentoMat;
    EditText txtConsultaCodigoMat;
    EditText txtConsultaGrupoMat;
    EditText txtConsultaJornadaMat;
    EditText txtConsultaProgramaAcademicoMat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_matricula);

        txtConsultaDocumentoMat = findViewById(R.id.txtConsultaDocumentoMat);
        txtConsultaCodigoMat = findViewById(R.id.txtConsultaCodigoMat);
        txtConsultaGrupoMat = findViewById(R.id.txtConsultaGrupoMat);
        txtConsultaJornadaMat = findViewById(R.id.txtConsultaJornadaMat);
        txtConsultaProgramaAcademicoMat = findViewById(R.id.txtConsultaProgramaAcademicoMat);

    }

    public void BuscarMatricula(View view){

        DbGestion dbGestion = new DbGestion(ConsultaMatricula.this, "Gestiondb", null, 4);
        SQLiteDatabase db = dbGestion.getReadableDatabase();

        String documento = txtConsultaDocumentoMat.getText().toString();

        if (!documento.isEmpty()){

            Cursor fila = db.rawQuery("SELECT codigoAsig,grupo,jornada,programaAcademica FROM t_matricula WHERE documento=" + documento, null);

            if (fila.moveToFirst()){
                txtConsultaCodigoMat.setText(fila.getString(0));
                txtConsultaGrupoMat.setText(fila.getString(1));
                txtConsultaJornadaMat.setText(fila.getString(2));
                txtConsultaProgramaAcademicoMat.setText(fila.getString(3));
                db.close();

            }else {
                Toast.makeText(ConsultaMatricula.this, "NO SE ENCUENTRA NINGUN MATRICULA", Toast.LENGTH_SHORT).show();
                limipar();
                db.close();
            }
        }else {
            Toast.makeText(ConsultaMatricula.this, "DEBES INGRESAR EL DOCUMENTO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limipar(){
        txtConsultaCodigoMat.setText("");
        txtConsultaGrupoMat.setText("");
        txtConsultaJornadaMat.setText("");
        txtConsultaProgramaAcademicoMat.setText("");
    }
}