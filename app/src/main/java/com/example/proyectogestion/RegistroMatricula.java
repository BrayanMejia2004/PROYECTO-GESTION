package com.example.proyectogestion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectogestion.BaseDatos.DbGestion;
import com.example.proyectogestion.BaseDatos.DbRegistroEstudiante;
import com.example.proyectogestion.BaseDatos.DbRegistroMatricula;
import com.example.proyectogestion.entidades.Asignatura;
import com.example.proyectogestion.entidades.Estudiante;
import com.example.proyectogestion.entidades.Matricula;

import java.util.ArrayList;
import java.util.List;

public class RegistroMatricula extends AppCompatActivity {

    Spinner spMCodigo;
    Spinner spMDocumento;
    EditText txtRegistroGrupoMatricula;
    EditText txtRegistroJornadaMatricula;
    EditText txtRegistroProgramaAcademicoMatricula;

    ArrayList<String> listamatricula;
    ArrayList<Asignatura> matriculaList;
    ArrayList<String>listadocumento;
    ArrayList<Estudiante> estudiantelist;
    DbGestion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_matricula);

        conn = new DbGestion(getApplicationContext(),"Gestiondb",null,4);

        spMCodigo = (Spinner) findViewById(R.id.spMCodigo);
        spMDocumento = (Spinner) findViewById(R.id.spMDocumento);

        txtRegistroGrupoMatricula = findViewById(R.id.txtRegistroGrupoMatricula);
        txtRegistroJornadaMatricula = findViewById(R.id.txtRegistroJornadaMatricula);
        txtRegistroProgramaAcademicoMatricula = findViewById(R.id.txtRegistroProgramaAcademicoMatricula);

        consultaCodigo();
        consultaDocumento();

        ArrayAdapter<Cursor> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listamatricula);
        spMCodigo.setAdapter(adapter);

        ArrayAdapter<Cursor> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listadocumento);
        spMDocumento.setAdapter(adapter1);
    }

    private void consultaCodigo(){

        SQLiteDatabase db = conn.getReadableDatabase();
        Asignatura asignatura = null;
        matriculaList = new ArrayList<Asignatura>();

        Cursor cursor = db.rawQuery(" SELECT * FROM t_asignatura", null);

        while (cursor.moveToNext()){
            asignatura = new Asignatura();
            asignatura.setCodigoAsig(cursor.getInt(0));
            asignatura.setNombreAsig(cursor.getString(1));
            asignatura.setCredioAsig(cursor.getInt(2));

            matriculaList.add(asignatura);
        }
        obtenerlista();
    }

    private void consultaDocumento(){

        SQLiteDatabase db = conn.getReadableDatabase();

        Estudiante estudiante = null;
        estudiantelist = new ArrayList<Estudiante>();

        Cursor cursor = db.rawQuery(" SELECT * FROM t_estudiante", null);

        while (cursor.moveToNext()){
            estudiante = new Estudiante();
            estudiante.setDocumento(cursor.getInt(0));
            estudiante.setNombre(cursor.getString(1));
            estudiante.setApellido(cursor.getString(2));
            estudiante.setFecha(cursor.getString(3));
            estudiante.setTelefono(cursor.getInt(4));
            estudiante.setCorreo(cursor.getString(5));

            estudiantelist.add(estudiante);
        }
        obtenerlistaDoc();
    }

    public void obtenerlista(){

        listamatricula = new ArrayList<String>();
        listamatricula.add("SELECCIONE EL CODIGO");

        for (int i=0; i<matriculaList.size(); i++){
                listamatricula.add(String.valueOf(matriculaList.get(i).getCodigoAsig()));
        }
    }

    public void obtenerlistaDoc(){

        listadocumento = new ArrayList<String>();
        listadocumento.add("SELLECCIONE EL DOCUMENTO");

        for (int i=0; i<estudiantelist.size(); i++){
                listadocumento.add(String.valueOf(estudiantelist.get(i).getDocumento()));
        }
    }

    public void RM (View view){
        DbRegistroMatricula dbRegistroMatricula = new DbRegistroMatricula(RegistroMatricula.this);
        long id = dbRegistroMatricula.insertaMatricula(Integer.parseInt((spMCodigo.getSelectedItem().toString())),
                Integer.parseInt(spMDocumento.getSelectedItem().toString()),
                Integer.parseInt(txtRegistroGrupoMatricula.getText().toString()),
                txtRegistroJornadaMatricula.getText().toString(),
                txtRegistroProgramaAcademicoMatricula.getText().toString());
        
        if (id > 0){
            Toast.makeText(RegistroMatricula.this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
            limpiar();
        }else {
            Toast.makeText(RegistroMatricula.this, "REGISTRO FALLIDO", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(){
        spMCodigo.setSelection(0);
        spMDocumento.setSelection(0);
        txtRegistroGrupoMatricula.setText("");
        txtRegistroJornadaMatricula.setText("");
        txtRegistroProgramaAcademicoMatricula.setText("");
    }
}