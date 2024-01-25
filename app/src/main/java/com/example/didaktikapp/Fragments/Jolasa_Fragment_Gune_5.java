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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jolasa_gune_5, container, false);
    }
    private ImageView Arrantza_Ontzia_C1;
    private ImageView Arrantza_Ontzia_C2;
    private ImageView Garraio_Ontzia_C1;
    private ImageView Garraio_Ontzia_C2;
    private ImageView Bela_Ontzia_C1;
    private ImageView Bela_Ontzia_C2;
    private ImageView Bale_Ontzia_C1;
    private ImageView Bale_Ontzia_C2;
    private ImageView Txalupa_C1;
    private ImageView Txalupa_C2;
    private ImageView Arraun_Ontzia_C1;
    private ImageView Arraun_Ontzia_C2;
    ImageView carta;
    ImageView itsasontzia_Arrantza;
    ImageView itsasontzia_Garraioa;
    ImageView itsasontzia_Bela;
    ImageView itsasontzia_Bale;
    ImageView itsasontzia_Txalupa;
    ImageView itsasontzia_Arraun;
    private int puntuazioa;
    private TextView puntuazioaErakutsi;
    private Handler handler = new Handler();
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

        carta.setImageResource(R.drawable.carta);
        itsasontzia_Arrantza.setImageResource(R.drawable.arrantza_ontzia);
        itsasontzia_Garraioa.setImageResource(R.drawable.garraio_ontzia);
        itsasontzia_Bela.setImageResource(R.drawable.belaontzia);
        itsasontzia_Bale.setImageResource(R.drawable.baleontzia);
        itsasontzia_Txalupa.setImageResource(R.drawable.txalupa);
        itsasontzia_Arraun.setImageResource(R.drawable.arraun_ontzia);

        //Itsasontzien argazkiak gordetzen ditugu
        List<Argazkiak_Ontziak> itsasontziak_argazkiak = new ArrayList<Argazkiak_Ontziak>();

        //Itsasontziak Kargatu
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,1, carta, itsasontzia_Arrantza,Arrantza_Ontzia_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,1, carta, itsasontzia_Arrantza,Arrantza_Ontzia_C2);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,2, carta, itsasontzia_Garraioa,Garraio_Ontzia_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,2, carta, itsasontzia_Garraioa,Garraio_Ontzia_C2);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,3, carta, itsasontzia_Bela,Bela_Ontzia_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,3, carta, itsasontzia_Bela,Bela_Ontzia_C2);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,4, carta, itsasontzia_Bale,Bale_Ontzia_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,4, carta, itsasontzia_Bale,Bale_Ontzia_C2);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,5, carta, itsasontzia_Txalupa,Txalupa_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,5, carta, itsasontzia_Txalupa,Txalupa_C2);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,6, carta, itsasontzia_Arraun,Arraun_Ontzia_C1);
        itsasontziak_argazkiak=aukeraBalidatu(itsasontziak_argazkiak,6, carta, itsasontzia_Arraun,Arraun_Ontzia_C2);

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

    }

    public List<Argazkiak_Ontziak> aukeraBalidatu(List<Argazkiak_Ontziak> itsasontziak_argazkiak, int bikote, ImageView carta, ImageView ontziak, ImageView erakutsi){

        ViewTreeObserver viewTreeObserver = carta.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] locationOnScreen = new int[2];
                carta.getLocationOnScreen(locationOnScreen);
                ontziak.getLocationOnScreen(locationOnScreen);
                erakutsi.getLocationOnScreen(locationOnScreen);
                Argazkiak_Ontziak argazki_obj = new Argazkiak_Ontziak(carta,ontziak,erakutsi,bikote,carta.getHeight(),carta.getWidth(),locationOnScreen[0],locationOnScreen[1]);
                for(int i = 0; i>itsasontziak_argazkiak.size(); i++) {
                    int index = i;
                    argazki_obj.getErakutsi().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (itsasontziak_argazkiak.get(index).isGorantz()) {
                                itsasontziak_argazkiak.get(index).setGorantz(true);
                                itsasontziak_argazkiak.get(index).setErakutsi(itsasontziak_argazkiak.get(index).getItsasontzia());
                            }
                        }
                    });
                }
                itsasontziak_argazkiak.add(argazki_obj);
            }
        });
        return itsasontziak_argazkiak;
    }
}