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

    @Query("SELECT * FROM erabiltzaileak")
    List<Erabiltzaile> getAllErabiltzaileak();

    @Query("SELECT * FROM erabiltzaileak WHERE id = :userId")
    Erabiltzaile getErabiltzaileById(int userId);

    @Query("SELECT * FROM erabiltzaileak WHERE email = :email")
    Erabiltzaile getErabiltzaileByEmail(String email);


    @Query("SELECT COUNT(*) FROM erabiltzaileak")
    int getErabiltzaileCount();

    @Update
    void updateErabiltzaile(Erabiltzaile erabiltzaile);

    @Delete
    void deleteErabiltzaile(Erabiltzaile erabiltzaile);
}
