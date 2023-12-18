package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "puntuazioak",
        foreignKeys = {
                @ForeignKey(
                        entity = Erabiltzaile.class,
                        parentColumns = "id",
                        childColumns = "erabiltzaileId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Jarduera.class,
                        parentColumns = "id",
                        childColumns = "jardueraId",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class Puntuazioa {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "puntuazioa")
    public int puntuazioa;

    @ColumnInfo(name = "erabiltzaileId")
    public int erabiltzaileId; // Erabiltzailearen FK da

    @ColumnInfo(name = "jardueraId")
    public int jardueraId; // Jardueraren FK da
}
