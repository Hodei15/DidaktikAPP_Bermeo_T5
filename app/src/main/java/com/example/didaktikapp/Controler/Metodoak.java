package com.example.didaktikapp.Controler;

import com.example.didaktikapp.Database.Dao.ErantzunaDao;
import com.example.didaktikapp.Database.Dao.GalderaDao;
import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Dao.JardueraDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erantzuna;
import com.example.didaktikapp.Database.Galdera;
import com.example.didaktikapp.Database.Gunea;
import com.example.didaktikapp.Database.Jarduera;

import java.util.List;

public class Metodoak {
    public static List<Gunea> guneakBete (Datubasea database){
        GuneaDao kontserbaGune = database.guneaDao();
        Gunea kontserbak = new Gunea(1, "Kontserbak",43.42105,-2.73617);
        Gunea arrain_saltzaileak = new Gunea(2, "Arrain saltzaileak",43.42126,-2.72304);
        Gunea Saregileen_murala = new Gunea(3, "Saregileen murala",43.42010,-2.72422);
        Gunea portua = new Gunea(4, "Portua",43.41737,-2.71997);
        Gunea xixili = new Gunea(5, "Xixili",43.42060,-2.71280);
        //Gunea elorrieta = new Gunea(6, "Elorrieta",43.28368,-2.96498);
        kontserbaGune.insertGunea(kontserbak);
        kontserbaGune.insertGunea(arrain_saltzaileak);
        kontserbaGune.insertGunea(Saregileen_murala);
        kontserbaGune.insertGunea(portua);
        kontserbaGune.insertGunea(xixili);
        //kontserbaGune.insertGunea(elorrieta);

        List<Gunea> guneak = kontserbaGune.getAllGuneak();

        return guneak;
    }
    public static List<Galdera> GalderakBete(Datubasea database){
        GalderaDao GalderaKontroladore = database.galderaDao();
        Galdera Orratza = new Galdera(1,"Zer erabiltzen zuten saregileak sarea egiteko?", 3);
        Galdera IparOrratza = new Galdera(2,"Zer erabiltzen dute itsasontzietan bidea aurkitzeko?", 3);
        Galdera Sarea = new Galdera(3,"Zer erabiltzen zuten arrantzaleek arrainak harrapatzeko? ", 3);
        Galdera Zapia = new Galdera(4,"Zer erabiltzen du saregilea bere burua eguzkitik babezteko?", 3);
        Galdera Kortxoa = new Galdera(5,"Zer dute sareek itsasoan ez ondoratzeko?", 3);
        GalderaKontroladore.insertGaldera(Orratza);
        GalderaKontroladore.insertGaldera(IparOrratza);
        GalderaKontroladore.insertGaldera(Sarea);
        GalderaKontroladore.insertGaldera(Zapia);
        GalderaKontroladore.insertGaldera(Kortxoa);

        List<Galdera> galderak = GalderaKontroladore.getAllGalderak();

        return galderak;
    }
    public static List<Jarduera> jardueraBete(Datubasea database){
        JardueraDao jardueraKontroladore = database.jardueraDao();
        Jarduera kontserba = new Jarduera(1, "Kontserba Fabrika");
        Jarduera arrainak = new Jarduera(2, "Arrain Saltzaileak");
        Jarduera murala = new Jarduera(3, "Saregileen Murala");
        Jarduera portua = new Jarduera(4, "Portua");
        Jarduera xixili = new Jarduera(5, "Xixili lamia");
        jardueraKontroladore.insertJarduera(kontserba);
        jardueraKontroladore.insertJarduera(arrainak);
        jardueraKontroladore.insertJarduera(murala);
        jardueraKontroladore.insertJarduera(portua);
        jardueraKontroladore.insertJarduera(xixili);

        List<Jarduera> jarduerak = jardueraKontroladore.getAllJarduerak();

        return jarduerak;
    }
    public static List<Erantzuna> erantunaBete(Datubasea database, int erabiltzile_id){
        ErantzunaDao erantzunaKontroladore = database.erantzunaDao();
        Erantzuna Orratza = new Erantzuna(1, "Orratza", 1, erabiltzile_id);
        Erantzuna IparOrratza = new Erantzuna(2, "IparOrratza",2, erabiltzile_id);
        Erantzuna Sarea = new Erantzuna(3, "Sarea",3, erabiltzile_id);
        Erantzuna Zapia = new Erantzuna(4, "Zapia",4, erabiltzile_id);
        Erantzuna Kortxoa = new Erantzuna(5, "Kortxoa",5, erabiltzile_id);
        erantzunaKontroladore.insertErantzuna(Orratza);
        erantzunaKontroladore.insertErantzuna(IparOrratza);
        erantzunaKontroladore.insertErantzuna(Sarea);
        erantzunaKontroladore.insertErantzuna(Zapia);
        erantzunaKontroladore.insertErantzuna(Kortxoa);

        List<Erantzuna> erantzunak = erantzunaKontroladore.getAllErantzunak();
        return erantzunak;
    }
}
