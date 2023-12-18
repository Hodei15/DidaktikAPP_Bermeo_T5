package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.didaktikapp.Database.Erabiltzaile;

import java.util.List;

@Dao
public interface ErabiltzaileDao {
    @Insert
    void insertErabiltzaile(Erabiltzaile erabiltzaile);

    @Query("SELECT * FROM erabiltzaile")
    List<Erabiltzaile> getAllErabiltzaileak();

    @Query("SELECT * FROM erabiltzaile WHERE id = :userId")
    Erabiltzaile getErabiltzaileById(int userId);

    @Update
    void updateErabiltzaile(Erabiltzaile erabiltzaile);

    @Delete
    void deleteErabiltzaile(Erabiltzaile erabiltzaile);
}
