package com.example.didaktikapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "erabiltzaileak")
public class Erabiltzaile {


    public Erabiltzaile(String email){
        this.email = email;
    }

    public Erabiltzaile(){
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "apellido")
    public String apellido;

    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "klasea")
    public String klasea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKlasea() {
        return klasea;
    }

    public void setKlasea(String klasea) {
        this.klasea = klasea;
    }
}

