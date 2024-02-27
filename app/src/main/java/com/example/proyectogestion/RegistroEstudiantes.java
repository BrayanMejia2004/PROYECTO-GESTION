package com.example.proyectogestion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectogestion.BaseDatos.DbRegistroDocente;
import com.example.proyectogestion.BaseDatos.DbRegistroEstudiante;

public class RegistroEstudiantes extends AppCompatActivity {

    EditText txtRegistroDocumentoEstudiante;
    EditText txtRegistroNombreEstudiante;
    EditText txtRegistroApellidoEstudiante;
    EditText txtRegistroFechaEstudiante;
    EditText txtRegistroTelefonoEstudiante;
    EditText txtRegistroCorreoEstudiante;

    Button btnREstudiante;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estudiantes);

        txtRegistroDocumentoEstudiante = findViewById(R.id.txtRegistroDocumentoEstudiante);
        txtRegistroNombreEstudiante = findViewById(R.id.txtRegistroNombreEstudiante);
        txtRegistroApellidoEstudiante = findViewById(R.id.txtRegistroApellidoEstudiante);
        txtRegistroFechaEstudiante = findViewById(R.id.txtRegistroFechaEstudiante);
        txtRegistroTelefonoEstudiante = findViewById(R.id.txtRegistroTelefonoEstudiante);
        txtRegistroCorreoEstudiante = findViewById(R.id.txtRegistroCorreoEstudiante);
        btnREstudiante = findViewById(R.id.btnREstudiante);

        btnREstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbRegistroEstudiante dbRegistroEstudiante = new DbRegistroEstudiante(RegistroEstudiantes.this);
                long id = dbRegistroEstudiante.instsertaEstudiante(Integer.parseInt(txtRegistroDocumentoEstudiante.getText().toString()),
                        txtRegistroNombreEstudiante.getText().toString(),
                        txtRegistroApellidoEstudiante.getText().toString(),
                        txtRegistroFechaEstudiante.getText().toString(),
                        Integer.parseInt(txtRegistroTelefonoEstudiante.getText().toString()),
                        txtRegistroCorreoEstudiante.getText().toString());

                if (id > 0){
                    Toast.makeText(RegistroEstudiantes.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(RegistroEstudiantes.this, "REGISTRO FALLIDO", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void limpiar(){
        txtRegistroDocumentoEstudiante.setText("");
        txtRegistroNombreEstudiante.setText("");
        txtRegistroApellidoEstudiante.setText("");
        txtRegistroFechaEstudiante.setText("");
        txtRegistroTelefonoEstudiante.setText("");
        txtRegistroCorreoEstudiante.setText("");
    }
}