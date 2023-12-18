package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.didaktikapp.Database.Jarduera;

import java.util.List;

@Dao
public interface JardueraDao {
    @Insert
    void insertJarduera(Jarduera jarduera);

    @Query("SELECT * FROM jarduerak")
    List<Jarduera> getAllJarduerak();

    @Query("SELECT * FROM jarduerak WHERE id = :jarduerId")
    Jarduera getJardueraById(int jarduerId);

    @Update
    void updateJarduera(Jarduera jarduera);

    @Delete
    void deleteJarduera(Jarduera jarduera);
}