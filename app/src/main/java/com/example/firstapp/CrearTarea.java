package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.firstapp.DataBase.AppDataBase;
import com.example.firstapp.Models.Tarea;

public class CrearTarea extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombretarea, etUrgenciaTarea;
    private Button btnCrearTarea;

    private Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);

        etNombretarea = findViewById(R.id.et_tarea_crear);
        etUrgenciaTarea = findViewById(R.id.et_urgencia_crear);
        btnCrearTarea = findViewById(R.id.btn_crear_tarea);


        btnCrearTarea.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String titulo = etNombretarea.getText().toString();
        String urgencia = etUrgenciaTarea.getText().toString();

        if (v == btnCrearTarea) {


            crearTarea(titulo,urgencia);
        }

    }

    private void obtenerInput() {

        String titulo = etNombretarea.getText().toString();
        String urgencia = etUrgenciaTarea.getText().toString();

    }

    private void crearTarea(String titulo, String urgencia) {

        final Tarea t1 = new Tarea(titulo, urgencia, false, false);

        new Thread(new Runnable() {
            @Override
            public void run() {

                AppDataBase dB = AppDataBase.getInstance(CrearTarea.this);

                dB.getTareasDao().crearTareas(t1);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(CrearTarea.this, "Tarea creada",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

    }
}
