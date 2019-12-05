package com.example.firstapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstapp.Adapters.TareasAdapter;
import com.example.firstapp.DataBase.AppDataBase;
import com.example.firstapp.DataBase.TareasDao;
import com.example.firstapp.Models.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TareasActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Tarea> tareasList;
    private Button btnCrearTareas;
    private Button btnTareasTerminadas;
    private TareasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        tareasList = new ArrayList<>();
        this.agregarTareas();

        btnCrearTareas = findViewById(R.id.btn_crear_tarea_nueva);



        btnCrearTareas.setOnClickListener(this);

        btnTareasTerminadas = findViewById(R.id.btn_ver_tareas_terminadas);

        btnTareasTerminadas.setOnClickListener(this);



        ListView lvTareas = findViewById(R.id.lv_tareas);

        lvTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });

        adapter = new TareasAdapter(tareasList);


        lvTareas.setAdapter(adapter);

        Toolbar toolBar = findViewById(R.id.toolbar);

        setSupportActionBar(toolBar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("Listado Tareas");


        }


//        ActionBar actionBar = getSupportActionBar();
//
//        if (actionBar != null) {
//
//            actionBar.setTitle("Listado Tareas");
//
//        }


    }

    private void agregarTareas() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                tareasList.clear();


                final AppDataBase dB = AppDataBase.getInstance(TareasActivity.this);

                tareasList.addAll(dB.getTareasDao().obtenerTareas());


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapter.notifyDataSetChanged();
                    }
                });

            }


        }).start();

    }


    public void crearTareas() {

        Intent intent = new Intent(TareasActivity.this, CrearTarea.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        if (v == btnCrearTareas) {

            crearTareas();
        }


        if (v == btnTareasTerminadas) {

            Intent intent = new Intent(TareasActivity.this, TareasTerminadas.class);

            startActivity(intent);

        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tareas_activity, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_abrir_perfil) {

            Intent intent = new Intent(TareasActivity.this, PerfilUsuarioActivity.class);

            startActivity(intent);


        } else if (id == R.id.action_abrir_tareas_terminadas) {

            Intent intent = new Intent(TareasActivity.this, TareasTerminadas.class);

            startActivity(intent);


        } else if (id == R.id.action_crear_tarea) {


            startActivity(new Intent(this, CrearTarea.class));

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.agregarTareas();
    }


}
