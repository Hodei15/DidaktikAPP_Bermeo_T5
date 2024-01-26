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

    @Query("SELECT COUNT(*) FROM erantzunak")
    int getErantzunCount();

    @Query("SELECT erantzuna FROM erantzunak WHERE id_galdera= :galdera AND id_erabiltzaile= (SELECT id FROM erabiltzaileak WHERE nombre= :erabiltzaile_izen AND apellido= :erabiltzaile_abizen)")
    int getErabiltzaileErantzuna(int galdera,String erabiltzaile_izen, String erabiltzaile_abizen);
}
