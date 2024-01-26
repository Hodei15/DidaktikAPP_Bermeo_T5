package com.example.didaktikapp.Fragments;

import android.content.Context;
import android.content.Intent;
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

import com.example.didaktikapp.Activity.Gune_1_Activity;
import com.example.didaktikapp.Activity.Menu_Gune_Activity;
import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.Argazkiak_Ontziak;
import com.example.didaktikapp.Model.EsperaImagen;
import com.example.didaktikapp.R;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jolasa_gune_5, container, false);
        //ikaslearen puntuaketa kalkulatzeko atributuak
        puntuazioa = 1000;
        puntuazioaErakutsi = view.findViewById(R.id.txt_puntuazioa_5);

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
        List<Argazkiak_Ontziak> itsasontziak_argazkiak = new ArrayList<Argazkiak_Ontziak>();

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

        Arrantza_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //aukeraBalidatu();
            }
        });

        //puntuaketari segunduro 10 puntu kentzeko metodoa
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                puntuazioa -= 10;
                puntuazioaErakutsi.setText(String.valueOf(puntuazioa));
                handler.postDelayed(this, 1000);
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
                            if (!argazki_obj.isGorantz()) {
                                argazki_obj.setGorantz(true);
                                argazki_obj.getErakutsi().setImageResource(argazki_obj.getItsasontzia());

                                aukeraBalidatu(itsasontziak_argazkiak);
                            }
                        }
                    });
                    itsasontziak_argazkiak.add(argazki_obj);
                }
            }
        });
        return itsasontziak_argazkiak;
    }

    public boolean aukeraBalidatu(List<Argazkiak_Ontziak> itsasontziak_argazkiak){
        boolean jolasa_amaituta = true;
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
        }else if(index_1!=-1 && index_2!=-1 && itsasontziak_argazkiak.get(index_1).getBikote()!=itsasontziak_argazkiak.get(index_2).getBikote()){
            itsasontziak_argazkiak.get(index_1).setGorantz(false);
            itsasontziak_argazkiak.get(index_2).setGorantz(false);
            //Falta asignar la imagen de la carta
            itsasontziak_argazkiak.get(index_1).getErakutsi().setImageResource(itsasontziak_argazkiak.get(index_1).getImgCarta());
            itsasontziak_argazkiak.get(index_2).getErakutsi().setImageResource(itsasontziak_argazkiak.get(index_2).getImgCarta());
        }

        //Jolasa amaitu bada balidatzen du
        for(int i=0;i<itsasontziak_argazkiak.size() && jolasa_amaituta;i++){
            if(!itsasontziak_argazkiak.get(i).isLotuta()){
                jolasa_amaituta = false;
            }
        }
        return jolasa_amaituta;
    }
}