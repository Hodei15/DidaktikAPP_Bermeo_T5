package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "guneak")
public class Gunea {
    public Gunea(int id, String izena, double lat, double lon) {
        this.id = id;
        this.izena = izena;
        this.lat = lat;
        this.lon = lon;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "izena")
    public String izena;

    @ColumnInfo(name = "lat")
    public double lat;

    @ColumnInfo(name = "lon")
    public double lon;
}

