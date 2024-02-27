package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void intermediaDocentes(View view){
        Intent intent = new Intent(this, IntermediaDocentes.class);
        startActivity(intent);
    }

    public void intermediaEstudiantes(View view){
        Intent intent = new Intent(this, IntermediaEstudiantes.class);
        startActivity(intent);
    }

    public void intermediaAsignatura(View view){
        Intent intent = new Intent(this, IntermediaAsignatura.class);
        startActivity(intent);
    }

    public void intemrediaMatricula(View view){
        Intent intent = new Intent(this, IntermediaMatricula.class);
        startActivity(intent);
    }
}