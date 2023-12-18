package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.didaktikapp.Database.Puntuazioa;

import java.util.List;

@Dao
public interface PuntuazioaDao {
    @Insert
    void insertPuntuazioa(Puntuazioa puntuazioa);

    @Query("SELECT * FROM puntuazioak")
    List<Puntuazioa> getAllPuntuazioak();

    @Query("SELECT * FROM puntuazioak WHERE erabiltzaileId = :userId")
    List<Puntuazioa> getPuntuazioakByUserId(int userId);

    @Update
    void updatePuntuazioa(Puntuazioa puntuazioa);

    @Delete
    void deletePuntuazioa(Puntuazioa puntuazioa);
}
