package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.firstapp.Adapters.TareasAdapter;
import com.example.firstapp.Models.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TareasTerminadas extends AppCompatActivity {

    private List<Tarea> tareasListTerminadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas_terminadas);


        tareasListTerminadas = new ArrayList<>();


        ListView lvTareasTerminadas = findViewById(R.id.lv_tareas_terminadas);

        lvTareasTerminadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        TareasAdapter adapter = new TareasAdapter(tareasListTerminadas);


        lvTareasTerminadas.setAdapter(adapter);

        this.agregarTareasTerminadas();
    }


    private void agregarTareasTerminadas() {


        Tarea t1 = new Tarea("Lavar la Ropa", "urgente", false, true);

        Tarea t2 = new Tarea("Sacar la basura", "Urgente", false, true);


        tareasListTerminadas.add(t1);
        tareasListTerminadas.add(t2);


    }


}
