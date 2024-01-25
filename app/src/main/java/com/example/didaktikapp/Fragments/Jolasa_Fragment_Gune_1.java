package com.example.didaktikapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.DibujoView;
import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean bukatuta;

    public Jolasa_Fragment_Gune_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jolasa_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_1 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_1 fragment =  new Jolasa_Fragment_Gune_1();
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

    private DibujoView dibujoView;
    private int puntuazioa;
    private TextView puntuazioaErakutsi;
    private Handler handler = new Handler();
    private boolean todasImagenesJuntadas = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jolasa_gune_1, container, false);
        //ikaslearen puntuaketa kalkulatzeko atributuak
        puntuazioa = 1000;
        puntuazioaErakutsi = view.findViewById(R.id.txt_puntuazioa_1);

        //atributuak deklaratu
        dibujoView = view.findViewById(R.id.dibujoView);
        ImageView img_correcto = view.findViewById(R.id.img_correcto);
        dibujoView.setImg_correcto(img_correcto);
        puntuazioaErakutsi.setText(String.valueOf(puntuazioa));

        //puntuaketari segunduro 10 puntu kentzeko metodoa
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (puntuazioa > 0) {
                    puntuazioa -= 50;
                    puntuazioaErakutsi.setText(String.valueOf(puntuazioa));
                    handler.postDelayed(this, 1000);
                } else {
                    puntuazioaErakutsi.setText(String.valueOf(puntuazioa));
                }
            }
        }, 1000);

        //Argazkiak lortzen ditugu
        ImageView arrain_1 = view.findViewById(R.id.img_arrain_bikote_1);
        ImageView arrain_2 = view.findViewById(R.id.img_arrain_bikote_2);
        ImageView arrain_3 = view.findViewById(R.id.img_arrain_bikote_3);
        ImageView arrain_4 = view.findViewById(R.id.img_arrain_bikote_4);
        ImageView arrain_5 = view.findViewById(R.id.img_arrain_bikote_5);
        ImageView lata_1 = view.findViewById(R.id.img_lata_bikote_1);
        ImageView lata_2 = view.findViewById(R.id.img_lata_bikote_2);
        ImageView lata_3 = view.findViewById(R.id.img_lata_bikote_3);
        ImageView lata_4 = view.findViewById(R.id.img_lata_bikote_4);
        ImageView lata_5 = view.findViewById(R.id.img_lata_bikote_5);

        //Arrain argazkiak gordetzen ditugu
        List<Argazki> arrain_argazkiak = new ArrayList<Argazki>();
        //Lata argazkiak gordetzen ditugu
        List<Argazki> lata_argazkiak = new ArrayList<Argazki>();

        //Arrainak kargatu
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,1,arrain_1);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,2,arrain_2);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,3,arrain_3);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,4,arrain_4);
        arrain_argazkiak=agazkiakKargatu(arrain_argazkiak,5,arrain_5);

        //Latak kargatu
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,1,lata_1);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,2,lata_2);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,3,lata_3);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,4,lata_4);
        lata_argazkiak=agazkiakKargatu(lata_argazkiak,5,lata_5);

        dibujoView.setArrainak(arrain_argazkiak);
        dibujoView.setLatak(lata_argazkiak);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public void setGune1Value(boolean gune1) {
        //Booleanoa
        this.bukatuta = gune1;
    }


    private void limpiarDibujo() {
        dibujoView.limpiarDibujo();
    }

    private List<Argazki> agazkiakKargatu(List<Argazki> argazkiak,int bikote, ImageView argazki){

        ViewTreeObserver viewTreeObserver = argazki.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] locationOnScreen = new int[2];
                argazki.getLocationOnScreen(locationOnScreen);
                Argazki argazki_obj = new Argazki(argazki,bikote,argazki.getHeight(),argazki.getWidth(),locationOnScreen[0],locationOnScreen[1]);
                argazkiak.add(argazki_obj);
            }
        });
        return argazkiak;
    }

}