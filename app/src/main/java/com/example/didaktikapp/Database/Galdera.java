package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "galderak",
        foreignKeys = @ForeignKey(
                entity = Jarduera.class,
                parentColumns = "id",
                childColumns = "id_jarduera",
                onDelete = ForeignKey.CASCADE
        )
)
public class Galdera {
        public Galdera(int id, String galdera, int id_jarduera){
                this.id = id;
                this.galdera = galdera;
                this.id_jarduera = id_jarduera;
        }

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        public int id;

        @ColumnInfo(name = "galdera")
        public String galdera;

        @ColumnInfo(name = "id_jarduera")
        public int id_jarduera; //  Jardueraren FK da
}
