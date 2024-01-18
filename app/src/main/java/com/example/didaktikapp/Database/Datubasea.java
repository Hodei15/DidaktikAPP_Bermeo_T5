package com.example.didaktikapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.didaktikapp.Database.Dao.ErabiltzaileDao;
import com.example.didaktikapp.Database.Dao.ErantzunaDao;
import com.example.didaktikapp.Database.Dao.GalderaDao;
import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Dao.JardueraDao;

@Database(entities = {Erabiltzaile.class, Puntuazioa.class, Jarduera.class, Gunea.class, Galdera.class, Erantzuna.class}, version = 3)
public abstract class Datubasea extends RoomDatabase {
    public abstract ErabiltzaileDao erabiltzaileDao();
    public abstract GuneaDao guneaDao();
    public abstract GalderaDao galderaDao();
    public abstract JardueraDao jardueraDao();
    public abstract ErantzunaDao erantzunaDao();


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
