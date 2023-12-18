package com.example.didaktikapp.Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.didaktikapp.Database.Erantzuna;

import java.util.List;

@Dao
public interface ErantzunaDao {
    @Insert
    void insertErantzuna(Erantzuna erantzuna);

    @Query("SELECT * FROM erantzunak")
    List<Erantzuna> getAllErantzunak();
}
