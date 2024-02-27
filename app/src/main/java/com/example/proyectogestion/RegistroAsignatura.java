package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbRegistroAsignatura;
import com.example.proyectogestion.BaseDatos.DbRegistroDocente;

public class RegistroAsignatura extends AppCompatActivity {

    EditText txtRegistroCodigoAsignatura;
    EditText txtRegistroNombreAsignatura;
    EditText txtRegistroCreditoAsignatura;
    Button btnRAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_asignatura);

        txtRegistroCodigoAsignatura = findViewById(R.id.txtRegistroCodigoAsignatura);
        txtRegistroNombreAsignatura = findViewById(R.id.txtRegistroNombreAsignatura);
        txtRegistroCreditoAsignatura = findViewById(R.id.txtRegistroCreditoAsignatura);
        btnRAsignatura = findViewById(R.id.btnRAsignatura);

        btnRAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbRegistroAsignatura dbRegistroAsignatura = new DbRegistroAsignatura(RegistroAsignatura.this);
                long id = dbRegistroAsignatura.insertaAsignatura(Integer.parseInt(txtRegistroCodigoAsignatura.getText().toString()),
                        txtRegistroNombreAsignatura.getText().toString(),
                        Integer.parseInt(txtRegistroCreditoAsignatura.getText().toString()));

                if (id > 0){
                    Toast.makeText(RegistroAsignatura.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(RegistroAsignatura.this, "REGISTRO FALLIDO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiar(){
        txtRegistroCodigoAsignatura.setText("");
        txtRegistroNombreAsignatura.setText("");
        txtRegistroCreditoAsignatura.setText("");
    }
}