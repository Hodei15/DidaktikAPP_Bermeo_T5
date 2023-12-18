package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

public class Erantzuna {
    @Entity(
            tableName = "erantzunak",
            foreignKeys = {
                    @ForeignKey(
                            entity = Erabiltzaile.class,
                            parentColumns = "id",
                            childColumns = "id_erabiltzaile",
                            onDelete = ForeignKey.CASCADE
                    ),
                    @ForeignKey(
                            entity = Galdera.class,
                            parentColumns = "id",
                            childColumns = "id_galdera",
                            onDelete = ForeignKey.CASCADE
                    )
            }
    )
    public class Erantzunak {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        public int id;

        @ColumnInfo(name = "erantzuna")
        public String erantzuna;

        @ColumnInfo(name = "id_erabiltzaile")
        public int id_erabiltzaile; // Erabiltzailearen FK da

        @ColumnInfo(name = "id_galdera")
        public int id_galdera; //Galdera id FK
    }
}
