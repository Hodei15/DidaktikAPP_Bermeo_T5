package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jarduerak")
public class Jarduera {

    public Jarduera(int id, String izena){
        this.id = id;
        this.izena = izena;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "izena")
    public String izena;
}
