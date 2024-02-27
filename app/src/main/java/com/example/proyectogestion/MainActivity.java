package com.example.proyectogestion;

import static com.example.proyectogestion.BaseDatos.DbGestion.DATABASE_NOMBRE;
import static com.example.proyectogestion.BaseDatos.DbGestion.DATABASE_VERSION;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbGestion;

import java.util.EnumSet;

public class MainActivity extends AppCompatActivity {

    EditText txtCorreoLogin;
    EditText txtContraseñaLogin;
    Button button15;
    Button btnIngresarPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreoLogin = findViewById(R.id.txtCorreoLogin);
        txtContraseñaLogin = findViewById(R.id.txtContraseñaLogin);
        button15 = findViewById(R.id.button15);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbGestion dbGestion = new DbGestion(MainActivity.this);

                SQLiteDatabase db = dbGestion.getWritableDatabase();

                if ( db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS FALLIDA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void menu(View view){

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void menu1(View view){
        Intent intent = new Intent(this, RegistroLogin.class);
        startActivity(intent);
    }

}