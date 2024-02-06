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

    @Query("SELECT erantzuna FROM erantzunak JOIN erabiltzaileak ON erantzunak.id_erabiltzaile=erabiltzaileak.id WHERE id_galdera= :galdera AND UPPER(erabiltzaileak.nombre)= UPPER(:izena) AND UPPER(erabiltzaileak.apellido)= UPPER(:abizena) AND UPPER(erabiltzaileak.klasea)= UPPER(:klasea)")
    String getErabiltzaileErantzuna(int galdera,String izena, String abizena, String klasea);

    @Query("SELECT id FROM erantzunak WHERE id_erabiltzaile= :id_erabiltzaile AND id_galdera= :id_galdera")
    int getErantzunId(int id_erabiltzaile, int id_galdera);
}
