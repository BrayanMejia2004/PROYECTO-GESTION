package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbResgistroLogin;

public class RegistroLogin extends AppCompatActivity {

    EditText editTextText36;
    EditText editTextText37;
    EditText editTextText38;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_login);

        editTextText36 = findViewById(R.id.editTextText36);
        editTextText37 = findViewById(R.id.editTextText37);
        editTextText38 = findViewById(R.id.editTextText38);
    }

    public void registrarLogin(View view){

        DbResgistroLogin dbResgistroLogin = new DbResgistroLogin(RegistroLogin.this);
        long id = dbResgistroLogin.insertarRegistroLogin(editTextText36.getText().toString(),
                editTextText37.getText().toString(),
                editTextText38.getText().toString());

        if (id > 0){
            Toast.makeText(RegistroLogin.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
            limpiar();
        }else {
            Toast.makeText(RegistroLogin.this, "REGISTRO FALLIDO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        editTextText36.setText("");
        editTextText37.setText("");
        editTextText38.setText("");
    }
}
