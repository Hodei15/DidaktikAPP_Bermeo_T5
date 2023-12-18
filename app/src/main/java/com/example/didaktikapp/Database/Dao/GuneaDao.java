package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.didaktikapp.Database.Gunea;

import java.util.List;

@Dao
public interface GuneaDao {
    @Insert
    void insertGunea(Gunea gunea);

    @Query("SELECT * FROM guneak")
    List<Gunea> getAllGuneak();
}
