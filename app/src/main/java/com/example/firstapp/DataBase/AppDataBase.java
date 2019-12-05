package com.example.firstapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.firstapp.Models.Tarea;

//Si hay mas de una solo se coloca una ","
@Database(entities = {Tarea.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract TareasDao getTareasDao();

    private static AppDataBase sInstance;

    public static AppDataBase getInstance(Context context) {

        if (sInstance == null) {

            sInstance = Room.databaseBuilder(context, AppDataBase.class, "AppDataBase").build();

        }

        return sInstance;
    }

}
