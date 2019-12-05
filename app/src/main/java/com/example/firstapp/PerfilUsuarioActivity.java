package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegistrarse;
    private EditText edad,codigoArea,telefono,ciudad,pais;
    private TextView nombre,apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        btnRegistrarse = findViewById(R.id.BtnGuardar);

        nombre = findViewById(R.id.tv_Nombre);
        apellido = findViewById(R.id.tv_Apellido);
        edad = findViewById(R.id.et_Edad);
        codigoArea = findViewById(R.id.et_CodigoArea);
        telefono = findViewById(R.id.et_Telefono);
        ciudad = findViewById(R.id.et_Ciudad);
        pais = findViewById(R.id.et_Pais);


        Toolbar toolBar = findViewById(R.id.toolbar_register);

        setSupportActionBar(toolBar);

        if(getSupportActionBar()!= null){

            getSupportActionBar().setTitle("Perfil Usuario");


        }

//        ActionBar actionBar = getSupportActionBar();
//
//        if( actionBar!= null){
//
//            actionBar.setTitle("Perfil");
//            actionBar.setDisplayHomeAsUpEnabled(true);
//
//        }



       btnRegistrarse.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v == btnRegistrarse){

            mostrarTareas();

        }


    }


    public void mostrarTareas() {

        Intent intent = new Intent(PerfilUsuarioActivity.this, TareasActivity.class);

        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_perfil_usuario, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_completada) {

            Intent intent = new Intent(PerfilUsuarioActivity.this, TareasActivity.class);

            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }
}
