package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Gunea {
    @Entity(tableName = "guneak")
    public class Guneak {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        public int id;

        @ColumnInfo(name = "izena")
        public String izena;

        @ColumnInfo(name = "koordenadak")
        public String koordenadak;
    }
}
