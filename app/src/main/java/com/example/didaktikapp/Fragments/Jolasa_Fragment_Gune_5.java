package com.example.didaktikapp.Fragments;

import static com.example.didaktikapp.Activity.Login_Activity.SHARED_PREFS;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didaktikapp.Activity.Gune_1_Activity;
import com.example.didaktikapp.Activity.Menu_Gune_Activity;
import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.Argazkiak_Ontziak;
import com.example.didaktikapp.Model.EsperaGorantz;
import com.example.didaktikapp.Model.EsperaImagen;
import com.example.didaktikapp.Model.EsperaOntziak;
import com.example.didaktikapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jolasa_Fragment_Gune_5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jolasa_Fragment_Gune_5.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_5 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_5 fragment = new Jolasa_Fragment_Gune_5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ImageView Arrantza_Ontzia_C1;
    private ImageView Arrantza_Ontzia_C2;
    private int drArrantzaOntzia = R.drawable.arrantza_ontzia;
    private ImageView Garraio_Ontzia_C1;
    private ImageView Garraio_Ontzia_C2;
    private int drGarraioOntzia = R.drawable.garraio_ontzia;
    private ImageView Bela_Ontzia_C1;
    private ImageView Bela_Ontzia_C2;
    private int drBelaOntzia = R.drawable.belaontzia;
    private ImageView Bale_Ontzia_C1;
    private ImageView Bale_Ontzia_C2;
    private int drBaleOntzia = R.drawable.baleontzia;
    private ImageView Txalupa_C1;
    private ImageView Txalupa_C2;
    private int drTxalupa = R.drawable.txalupa;
    private ImageView Arraun_Ontzia_C1;
    private ImageView Arraun_Ontzia_C2;
    private int drArraunOntzia = R.drawable.arraun_ontzia;
    private int carta=R.drawable.carta;
    private int puntuazioa;
    private TextView puntuazioaErakutsi;
    private Handler handler = new Handler();
    ImageView img_correcto5;
    boolean jolasa_amaituta;
    List<Argazkiak_Ontziak> itsasontziak_argazkiak;
    private Datubasea database;
    SharedPreferences sharedpreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jolasa_gune_5, container, false);

        //atributuak deklaratu
        sharedpreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        database = Datubasea.getDatabase(getActivity().getApplicationContext());

        //Erabiltzailea sharedPref-etik lortzen du
        Gson gson = new Gson();
        String json = sharedpreferences.getString("erabiltzaile", "");
        Erabiltzaile erabiltzaile = gson.fromJson(json, Erabiltzaile.class);

        //ikaslearen puntuaketa kalkulatzeko atributuak
        puntuazioa = 1000;
        puntuazioaErakutsi = view.findViewById(R.id.txt_puntuazioa_5);

        img_correcto5 = view.findViewById(R.id.img_correcto5);
        //Irudiak deklaratu
        Arrantza_Ontzia_C1 = view.findViewById(R.id.Arrantza_Ontzia_C1);
        Arrantza_Ontzia_C2 = view.findViewById(R.id.Arrantza_Ontzia_C2);
        Garraio_Ontzia_C1 = view.findViewById(R.id.Garraio_Ontzia_C1);
        Garraio_Ontzia_C2 = view.findViewById(R.id.Garraio_Ontzia_C2);
        Bela_Ontzia_C1 = view.findViewById(R.id.Bela_Ontzia_C1);
        Bela_Ontzia_C2 = view.findViewById(R.id.Bela_Ontzia_C2);
        Bale_Ontzia_C1 = view.findViewById(R.id.Bale_Ontzia_C1);
        Bale_Ontzia_C2 = view.findViewById(R.id.Bale_Ontzia_C2);
        Txalupa_C1 = view.findViewById(R.id.Txalupa_C1);
        Txalupa_C2 = view.findViewById(R.id.Txalupa_C2);
        Arraun_Ontzia_C1 = view.findViewById(R.id.Arraun_Ontzia_C1);
        Arraun_Ontzia_C2 = view.findViewById(R.id.Arraun_Ontzia_C2);


        //Itsasontzien argazkiak gordetzen ditugu
        itsasontziak_argazkiak = new ArrayList<Argazkiak_Ontziak>();

        //Itsasontziak Kargatu
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,1, carta, drArrantzaOntzia,Arrantza_Ontzia_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,1, carta, drArrantzaOntzia,Arrantza_Ontzia_C2);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,2, carta, drGarraioOntzia,Garraio_Ontzia_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,2, carta, drGarraioOntzia,Garraio_Ontzia_C2);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,3, carta, drBelaOntzia,Bela_Ontzia_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,3, carta, drBelaOntzia,Bela_Ontzia_C2);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,4, carta, drBaleOntzia,Bale_Ontzia_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,4, carta, drBaleOntzia,Bale_Ontzia_C2);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,5, carta, drTxalupa,Txalupa_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,5, carta, drTxalupa,Txalupa_C2);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,6, carta, drArraunOntzia,Arraun_Ontzia_C1);
        itsasontziak_argazkiak=argazkiaKargatu(itsasontziak_argazkiak,6, carta, drArraunOntzia,Arraun_Ontzia_C2);


        //puntuaketari segunduro 10 puntu kentzeko metodoa
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(puntuazioa>0 && !amaitutaBalidatu()) {
                    puntuazioa -= 10;
                    puntuazioaErakutsi.setText("Puntuazioa: " + puntuazioa);
                    handler.postDelayed(this, 1000);
                }else if(amaitutaBalidatu()){
                    if(Metodoak.erantzunaGordeRoom(database,String.valueOf(puntuazioa),5,erabiltzaile.getId())) {
                        Metodoak.erantzunaFirebaseGorde(String.valueOf(puntuazioa), 5, erabiltzaile.getEmail());
                        Toast.makeText(getActivity(), "Lortutako puntuazioa gorde egin da.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, 1000);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public List<Argazkiak_Ontziak> argazkiaKargatu(List<Argazkiak_Ontziak> itsasontziak_argazkiak, int bikote, int carta, int ontziak, ImageView erakutsi){

        ViewTreeObserver viewTreeObserver = erakutsi.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(itsasontziak_argazkiak.size()<12) {
                    int[] locationOnScreen = new int[2];
                    erakutsi.getLocationOnScreen(locationOnScreen);
                    Argazkiak_Ontziak argazki_obj = new Argazkiak_Ontziak(carta, ontziak, erakutsi, bikote, erakutsi.getHeight(), erakutsi.getWidth(), locationOnScreen[0], locationOnScreen[1]);
                    argazki_obj.getErakutsi().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!argazki_obj.isGorantz() && !eguneratzenBegiratu()) {
                                argazki_obj.setGorantz(true);
                                argazki_obj.getErakutsi().setImageResource(argazki_obj.getItsasontzia());

                                aukeraBalidatu();
                            }
                        }
                    });
                    itsasontziak_argazkiak.add(argazki_obj);
                }
            }
        });
        return itsasontziak_argazkiak;
    }

    public void aukeraBalidatu(){
        int index_1 = -1;
        int index_2 = -1;
        for (int j=0;j<itsasontziak_argazkiak.size() && index_2==-1;j++){
            if(itsasontziak_argazkiak.get(j).isGorantz() && !itsasontziak_argazkiak.get(j).isLotuta() && index_1==-1){
                index_1 = j;
            }else if (itsasontziak_argazkiak.get(j).isGorantz() && !itsasontziak_argazkiak.get(j).isLotuta() && index_1!=-1){
                index_2 = j;
            }
        }

        if(index_1!=-1 && index_2!=-1 && itsasontziak_argazkiak.get(index_1).getBikote()==itsasontziak_argazkiak.get(index_2).getBikote()){
            itsasontziak_argazkiak.get(index_1).setLotuta(true);
            itsasontziak_argazkiak.get(index_2).setLotuta(true);
            //Falta asignar la imagen de la carta
            try {
                this.img_correcto5.setImageResource(R.drawable.tick);
                EsperaImagen espera_correcto = new EsperaImagen(this.img_correcto5);
                this.img_correcto5.setVisibility(View.VISIBLE);
            }catch(Exception e){
            }
        }else if(index_1!=-1 && index_2!=-1 && itsasontziak_argazkiak.get(index_1).getBikote()!=itsasontziak_argazkiak.get(index_2).getBikote()){
            try {
                this.img_correcto5.setImageResource(R.drawable.cruz);
                EsperaImagen espera_correcto = new EsperaImagen(this.img_correcto5);
                img_correcto5.setVisibility(View.VISIBLE);
                EsperaOntziak espera_1 = new EsperaOntziak(itsasontziak_argazkiak.get(index_1));
                EsperaOntziak espera_2 = new EsperaOntziak(itsasontziak_argazkiak.get(index_2));
                EsperaGorantz gorantz_1 = new EsperaGorantz(itsasontziak_argazkiak.get(index_1));
                EsperaGorantz gorantz_2 = new EsperaGorantz(itsasontziak_argazkiak.get(index_2));
            }catch(Exception e){
            }
        }
    }

    public boolean amaitutaBalidatu(){
        boolean amaituta_prob = true;
        //Jolasa amaitu bada balidatzen du
        for(int i=0;i<itsasontziak_argazkiak.size() && amaituta_prob;i++){
            if(!itsasontziak_argazkiak.get(i).isLotuta()){
                amaituta_prob = false;
            }
        }
        if(amaituta_prob){
            jolasa_amaituta=true;
        }
        return jolasa_amaituta;
    }
    public boolean eguneratzenBegiratu(){
        boolean eguneratzen=false;
        int index_1 = -1;
        int index_2 = -1;
        for (int j=0;j<itsasontziak_argazkiak.size() && index_2==-1;j++){
            if(itsasontziak_argazkiak.get(j).isGorantz() && !itsasontziak_argazkiak.get(j).isLotuta() && index_1==-1){
                index_1 = j;
            }else if (itsasontziak_argazkiak.get(j).isGorantz() && !itsasontziak_argazkiak.get(j).isLotuta() && index_1!=-1){
                index_2 = j;
                eguneratzen = true;
            }
        }
        return eguneratzen;
    }

}