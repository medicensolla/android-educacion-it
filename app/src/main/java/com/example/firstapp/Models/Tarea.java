package com.example.firstapp.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Crea como tabla la clase
@Entity(tableName = "Tareas")

public class Tarea {

    //AutoGenera el ID
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String titulo;
    private String urgencia;
    private Boolean vencida;
    private Boolean terminada;


    public Tarea(String titulo, String urgencia, Boolean vencida, Boolean terminada) {
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.vencida = vencida;
        this.terminada = terminada;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public Boolean isVencida() {

        return vencida;
    }

    public void setVencida(Boolean vencida) {

        this.vencida = vencida;
    }

    public Boolean getTerminada() {

        return terminada;
    }

    public void setTerminada(Boolean terminada) {

        this.terminada = terminada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
