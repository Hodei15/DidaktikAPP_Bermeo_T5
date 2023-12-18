package com.example.didaktikapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.didaktikapp.Database.Dao.ErabiltzaileDao;

@Database(entities = {Erabiltzaile.class, Puntuazioa.class, Jarduera.class}, version = 2)
public abstract class Datubasea extends RoomDatabase {
    public abstract ErabiltzaileDao erabiltzaileDao();
    // Agrega Dao para las otras entidades aquí

    private static volatile Datubasea INSTANCE;

    public static Datubasea getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Datubasea.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    Datubasea.class,
                                    "app_database"
                    ).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
