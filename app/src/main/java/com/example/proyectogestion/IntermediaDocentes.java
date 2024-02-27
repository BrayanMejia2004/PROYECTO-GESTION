package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntermediaDocentes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia_docentes);
    }

    public void listaDocente(View view){
        Intent intent = new Intent(IntermediaDocentes.this, ListaDocentes.class);
        startActivity(intent);
    }

    public void consultaDocente(View view){
        Intent intent = new Intent(IntermediaDocentes.this, ConsultaDocentes.class);
        startActivity(intent);
    }

        public void registrarDocente(View view){
        Intent intent = new Intent(IntermediaDocentes.this, RegistrarDocentes.class);
        startActivity(intent);
        }
}