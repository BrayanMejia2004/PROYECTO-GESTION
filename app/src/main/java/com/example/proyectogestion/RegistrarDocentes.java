package com.example.proyectogestion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbRegistroDocente;

public class RegistrarDocentes extends AppCompatActivity {

    EditText txtRegistroDocumentoDocente;
    EditText txtRegistroNombreDocente;
    EditText txtRegistroApellidoDocente;
    EditText txtRegistroFechaDocente;
    EditText txtRegistroProfesionDocente;
    Button btnRDocente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_docentes);

        txtRegistroDocumentoDocente = findViewById(R.id.txtRegistroDocumentoDocente);
        txtRegistroNombreDocente = findViewById(R.id.txtRegistroNombreDocente);
        txtRegistroApellidoDocente = findViewById(R.id.txtRegistroApellidoDocente);
        txtRegistroFechaDocente = findViewById(R.id.txtRegistroFechaDocente);
        txtRegistroProfesionDocente = findViewById(R.id.txtRegistroProfesionDocente);
        btnRDocente = findViewById(R.id.btnRDocente);

        btnRDocente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbRegistroDocente dbRegistroDocente = new DbRegistroDocente(RegistrarDocentes.this);
                long id = dbRegistroDocente.insertaDocente(Integer.parseInt(txtRegistroDocumentoDocente.getText().toString()),
                        txtRegistroNombreDocente.getText().toString(),
                        txtRegistroApellidoDocente.getText().toString(),
                        txtRegistroFechaDocente.getText().toString(),
                        txtRegistroProfesionDocente.getText().toString());

                if (id > 0 ){
                    Toast.makeText(RegistrarDocentes.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(RegistrarDocentes.this, "REGISTRO FALLIDO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void limpiar(){
        txtRegistroDocumentoDocente.setText("");
        txtRegistroNombreDocente.setText("");
        txtRegistroApellidoDocente.setText("");
        txtRegistroFechaDocente.setText("");
        txtRegistroProfesionDocente.setText("");
    }
}