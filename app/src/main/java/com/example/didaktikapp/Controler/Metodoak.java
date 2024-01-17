package com.example.didaktikapp.Controler;

import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Gunea;

import java.util.List;

public class Metodoak {
    public static List<Gunea> guneakBete (Datubasea database){
        GuneaDao kontserbaGune = database.guneaDao();
        Gunea kontserbak = new Gunea(1, "Kontserbak",43.42105,-2.73617);
        Gunea arrain_saltzaileak = new Gunea(2, "Arrain saltzaileak",43.42126,-2.72304);
        Gunea Saregileen_murala = new Gunea(3, "Saregileen murala",43.42010,-2.72422);
        Gunea portua = new Gunea(4, "Portua",43.41737,-2.71997);
        Gunea xixili = new Gunea(5, "Xixili",43.42060,-2.71280);
        Gunea elorrieta = new Gunea(6, "Elorrieta",43.28368,-2.96498);
        kontserbaGune.insertGunea(kontserbak);
        kontserbaGune.insertGunea(arrain_saltzaileak);
        kontserbaGune.insertGunea(Saregileen_murala);
        kontserbaGune.insertGunea(portua);
        kontserbaGune.insertGunea(xixili);
        kontserbaGune.insertGunea(elorrieta);

        List<Gunea> guneak = kontserbaGune.getAllGuneak();

        return guneak;
    }
}
