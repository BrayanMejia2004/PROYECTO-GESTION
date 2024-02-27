package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntermediaMatricula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia_matricula);
    }

    public void listaAsignatura(View view){
        Intent intent = new Intent(this, ListaMatricula.class);
        startActivity(intent);
    }

    public void consultaAsignatura(View view){
        Intent intent = new Intent(this, ConsultaMatricula.class);
        startActivity(intent);
    }

    public void registrarAsignatura(View view){
        Intent intent = new Intent(this, RegistroMatricula.class);
        startActivity(intent);
    }
}