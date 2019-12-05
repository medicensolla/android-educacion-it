package com.example.firstapp.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.firstapp.Models.Tarea;

import java.util.List;

@Dao
public interface TareasDao {

    @Insert
    void crearTareas(Tarea tarea);

    @Query("SELECT * FROM Tareas")
    List<Tarea> obtenerTareas();

    @Query("SELECT * FROM Tareas WHERE id = :id")
    Tarea obtenerTarea(long id);


    @Update
    void actualizarTarea(Tarea t);


}
