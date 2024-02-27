package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntermediaAsignatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia_asignatura);
    }

    public void listaAsignatura(View view){
        Intent intent = new Intent(this, ListaAsignatura.class);
        startActivity(intent);
    }

    public void consultaAsignatura(View view){
        Intent intent = new Intent(this, ConsultaAsignatura.class);
        startActivity(intent);
    }

    public void registroAsignatura(View view){
        Intent intent = new Intent(this, RegistroAsignatura.class);
        startActivity(intent);
    }

}