package com.example.firstapp.Adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapp.DataBase.AppDataBase;
import com.example.firstapp.Models.Tarea;
import com.example.firstapp.R;
import com.example.firstapp.TareasActivity;

import java.util.List;

public class TareasAdapter extends BaseAdapter {

    private List<Tarea> tareas;


    public TareasAdapter(List<Tarea> tareas) {

        super();

        this.tareas = tareas;


    }


    @Override
    public int getCount() {
        return this.tareas.size();
    }

    @Override
    public Tarea getItem(int position) {
        return this.tareas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {


        View view;


        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tareas, parent, false);

        } else {
            view = convertView;
        }

        TextView tvTarea = view.findViewById(R.id.tv_tarea_nombre);

        TextView tvUrgencia = view.findViewById(R.id.tv_tarea_urgencia);

        TextView tvTerminada = view.findViewById(R.id.tv_tarea_vencida);

        final Button btnCerrarTarea = view.findViewById(R.id.btn_cerrar_tarea);


        final Tarea tarea = getItem(position);

        tvTarea.setText(this.getItem(position).getTitulo());

        tvUrgencia.setText(this.getItem(position).getUrgencia());

        tvTerminada.setText(this.getItem(position).getTerminada().toString());

        btnCerrarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == btnCerrarTarea) {


                    cerrarTarea(parent.getContext(), tarea);

                }
            }
        });


        return view;
    }


    public void cerrarTarea(final Context context, final Tarea tarea) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                final AppDataBase dB = AppDataBase.getInstance(context);


                if (tarea.getTerminada()) {

                    tarea.setTerminada(false);

                } else {

                    tarea.setTerminada(true);
                }


                dB.getTareasDao().actualizarTarea(tarea);

                Handler h = new Handler(Looper.getMainLooper());
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();

                    }
                };
                h.post(r);


            }
        }).start();

    }

}
