package com.example.didaktikapp.Controler;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;
import android.widget.Switch;

import androidx.annotation.NonNull;

import com.example.didaktikapp.Database.Dao.ErabiltzaileDao;
import com.example.didaktikapp.Database.Dao.ErantzunaDao;
import com.example.didaktikapp.Database.Dao.GalderaDao;
import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Dao.JardueraDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.Database.Erantzuna;
import com.example.didaktikapp.Database.Galdera;
import com.example.didaktikapp.Database.Gunea;
import com.example.didaktikapp.Database.Jarduera;
import com.example.didaktikapp.Model.Argazki;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metodoak {
    static int kantitatea =0;

    /**
     * Gure room datubasean guneen informazioa kargatzen du
     * @param database Room datubase instantzia
     * @return Guneen zerrenda
     */
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

    /**
     * Guneen galderak room datubasean gordetzen dira
     * @param database  Room datubase instantzia
     * @return Galdera zerrenda
     */
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

    /**
     * Room datubasean jarduerak kargatzen dira
     * @param database Room datubase instantzia
     * @return Jarduera zerrenda
     */
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
    /*
    public static List<Erantzuna> erantzunaBete(Datubasea database, int erabiltzile_id){
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
    }*/

    /**
     * Erabiltzaile guztiak kargatzen dira firebasetik, roomera
     * @param database Room datubasea
     */
    public static void erabiltzaileKargatu(FirebaseFirestore db,Datubasea database){
        ErabiltzaileDao erabiltzaileKontroladore = database.erabiltzaileDao();
        db.collection("erabiltzaileak").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Erabiltzaile erabiltzaile = document.toObject(Erabiltzaile.class);
                        int katitate_erabiltzaile = erabiltzaileKontroladore.getErabiltzaileCount();
                        erabiltzaile.setId(katitate_erabiltzaile+1);
                        int id=-1;
                        id = erabiltzaileKontroladore.getErabiltzaileId(erabiltzaile.getEmail());

                        if(id==-1 || id==0){
                            erabiltzaileKontroladore.insertErabiltzaile(erabiltzaile);
                        }
                    }
                    erantzunakLortuFirebase(database);
                } else {
                    Log.d(TAG, "Errorea Erantzunak betetzen", task.getException());
                }
            }
        });
    }

    /**
     * Room datubasetik erabiltzailea lortzen du
     * @param database Room datubasea
     * @param email Erabiltzailearen email
     * @return Erabiltzaile objetua
     */
    public static Erabiltzaile erabiltzaileaLortu(Datubasea database, String email){
        ErabiltzaileDao erabiltzaileKontroladore = database.erabiltzaileDao();
        Erabiltzaile erabiltzailea = erabiltzaileKontroladore.getErabiltzaileByEmail(email);
        return erabiltzailea;
    }

    /**
     * Firebasetik erantzunak lortzen eta gordetzen ditu room datubasean
     * @param database Room datubasea
     */
    public static void erantzunakLortuFirebase(Datubasea database) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        ErantzunaDao erantzunKontroler = database.erantzunaDao();
        ErabiltzaileDao erabiltzaileKontroler = database.erabiltzaileDao();

        db.collection("erantzunak").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());


                                String email = "";
                                String erantzun_1 = "";
                                String erantzun_2 = "";
                                String erantzun_3 = "";
                                String erantzun_4 = "";
                                String erantzun_5 = "";

                                try {
                                    email = document.get("email").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago erabiltzailearen erregistrorik.");}
                                try {
                                erantzun_1 = document.get("galdera_1").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago gune honen erantzunik.");
                                }
                                try {
                                erantzun_2 = document.get("galdera_2").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago gune honen erantzunik.");
                                }
                                try {
                                erantzun_3 = document.get("galdera_3").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago gune honen erantzunik.");
                                }
                                try {
                                erantzun_4 = document.get("galdera_4").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago gune honen erantzunik.");
                                }
                                try {
                                erantzun_5 = document.get("galdera_5").toString();
                                }catch (Exception e){
                                    Log.d(TAG, "Ez dago gune honen erantzunik.");
                                }

                                int erabiltzaile_id = erabiltzaileKontroler.getErabiltzaileId(email);

                                int id_erantzuna = erantzunKontroler.getErantzunCount();

                                if(!erantzun_1.equals("") && erantzunKontroler.getErantzunId(erabiltzaile_id,1)==0){
                                    id_erantzuna++;
                                    Erantzuna erantzun = new Erantzuna(id_erantzuna,erantzun_1,1,erabiltzaile_id);
                                    erantzunKontroler.insertErantzuna(erantzun);
                                }
                                if(!erantzun_2.equals("") && erantzunKontroler.getErantzunId(erabiltzaile_id,2)==0){
                                    id_erantzuna++;
                                    Erantzuna erantzun = new Erantzuna(id_erantzuna,erantzun_2,2,erabiltzaile_id);
                                    erantzunKontroler.insertErantzuna(erantzun);
                                }
                                if(!erantzun_3.equals("") && erantzunKontroler.getErantzunId(erabiltzaile_id,3)==0){
                                    id_erantzuna++;
                                    Erantzuna erantzun = new Erantzuna(id_erantzuna,erantzun_3,3,erabiltzaile_id);
                                    erantzunKontroler.insertErantzuna(erantzun);
                                }
                                if(!erantzun_4.equals("") && erantzunKontroler.getErantzunId(erabiltzaile_id,4)==0){
                                    id_erantzuna++;
                                    Erantzuna erantzun = new Erantzuna(id_erantzuna,erantzun_4,4,erabiltzaile_id);
                                    erantzunKontroler.insertErantzuna(erantzun);
                                }
                                if(!erantzun_5.equals("") && erantzunKontroler.getErantzunId(erabiltzaile_id,5)==0){
                                    id_erantzuna++;
                                    Erantzuna erantzun = new Erantzuna(id_erantzuna,erantzun_5,5,erabiltzaile_id);
                                    erantzunKontroler.insertErantzuna(erantzun);
                                }


                            }
                        } else {
                            Log.d(TAG, "Errorea Erantzunak betetzen", task.getException());
                        }
                    }
                });
    }

    /**
     * Erabiltzailea sortutako erantzuna firebase eta room datubaseetan gordetzen ditu
     * @param database Room datubase
     * @param erantzuna_erabiltzaile erantzuna
     * @param id_erabiltzaile erabiltzailearen id
     * @param id_galdera galderaren id
     * @param mail erabiltzailearen email
     */
    private void erantzunaGorde(Datubasea database,String erantzuna_erabiltzaile, int id_erabiltzaile, int id_galdera, String mail) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //Room-etik lortzen du erantzun id +1
        ErantzunaDao erantzunKontroladore = database.erantzunaDao();
        int id_erantzuna = 1+ erantzunKontroladore.getErantzunCount();

        Erantzuna e1 = new Erantzuna(id_erantzuna,erantzuna_erabiltzaile,id_galdera,id_erabiltzaile);
        db.collection("erantzunak").document(mail).set(e1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Erantzunak Gorde dira");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "Errorea Erantzunak  ezin izan dira gorde");
                    }
                });
    }

    /**
     * Erabiltzaileak lortutako erantzuna gordetzen du room datubasean
     * @param database Room datubasea
     * @param erantzuna Lortutako erantzuna
     * @param id_galdera Gunearen id
     * @param id_erabiltzaile Erabiltzailearen id
     */
    public static boolean erantzunaGordeRoom (Datubasea database, String erantzuna, int id_galdera, int id_erabiltzaile){
        boolean gordeta = false;
        int erantzun_id = 0;

        ErantzunaDao erantzunaKontroler = database.erantzunaDao();
        int count = 1+erantzunaKontroler.getErantzunCount();
        erantzun_id = erantzunaKontroler.getErantzunId(id_erabiltzaile,id_galdera);

        //Erabiltzailea erantzunik gorde ez badu gune horretan gordetzen du
        if(erantzun_id==0) {
            Erantzuna erantzun_obj = new Erantzuna(count, erantzuna, id_galdera, id_erabiltzaile);
            erantzunaKontroler.insertErantzuna(erantzun_obj);
            gordeta = true;
        }
        return gordeta;
    }

    /**
     * Erabiltzailea lortutako erantzuna gordetzen du
     * @param erantzuna Erantzuna edo puntuazioa
     * @param id_galdera Gunearen id
     * @param erabiltzaile_email Eranbiltzailearen email
     */
    public static void erantzunaFirebaseGorde(String erantzuna, int id_galdera, String erabiltzaile_email){
        String galdera_url="";
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        switch(id_galdera){
            case 1:
                galdera_url="galdera_1";
                break;
            case 2:
                galdera_url="galdera_2";
                break;
            case 3:
                galdera_url="galdera_3";
                break;
            case 4:
                galdera_url="galdera_4";
                break;
            case 5:
                galdera_url="galdera_5";
                break;
        }

        // Construye la referencia al documento
        DocumentReference docRef = db.collection("erantzunak").document(erabiltzaile_email);

        // Crea un mapa para almacenar el campo que deseas actualizar o crear
        Map<String, Object> actualizacion = new HashMap<>();
        actualizacion.put(galdera_url, erantzuna);
        actualizacion.put("email", erabiltzaile_email);

        // Actualiza el campo específico en el documento
        docRef.set(actualizacion, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // La operación fue exitosa
                        Log.d("TAG", "Documento actualizado o creado correctamente");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Error al intentar actualizar o crear el documento
                        Log.e("TAG", "Error al actualizar o crear el documento", e);
                    }
                });
    }

}
