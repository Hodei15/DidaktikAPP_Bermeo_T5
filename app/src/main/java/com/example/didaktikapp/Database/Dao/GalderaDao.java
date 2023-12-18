package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.didaktikapp.Database.Galdera;

import java.util.List;

@Dao
public interface GalderaDao {
    @Insert
    void insertGaldera(Galdera galdera);

    @Query("SELECT * FROM galderak")
    List<Galdera> getAllGalderak();
}
