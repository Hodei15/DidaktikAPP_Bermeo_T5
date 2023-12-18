package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

public class Galdera {
    @Entity(
            tableName = "galderak",
            foreignKeys = @ForeignKey(
                    entity = Jarduera.class,
                    parentColumns = "id",
                    childColumns = "id_jarduera",
                    onDelete = ForeignKey.CASCADE
            )
    )
    public class Galderak {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        public int id;

        @ColumnInfo(name = "galdera")
        public String galdera;

        @ColumnInfo(name = "id_jarduera")
        public int id_jarduera; //  Jardueraren FK da
    }
}
