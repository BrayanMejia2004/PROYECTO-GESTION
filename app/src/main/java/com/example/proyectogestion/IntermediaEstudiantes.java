package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntermediaEstudiantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia_estudiantes);
    }

    public void listaEstudiante(View view){
        Intent intent = new Intent(this, ListaEstudiantes.class);
        startActivity(intent);
    }

    public void consultaEstudiante(View view){
        Intent intent = new Intent(this, ConsultaEstudiantes.class);
        startActivity(intent);
    }

    public void registroEstudiante(View view){
        Intent intent = new Intent(this, RegistroEstudiantes.class);
        startActivity(intent);
    }
}