package com.example.didaktikapp.Fragments;

import static java.lang.Math.abs;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.ZatiTxo;
import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jolasa_Fragment_Gune_4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jolasa_Fragment_Gune_4.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_4 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_4 fragment = new Jolasa_Fragment_Gune_4();
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


    private ImageView cabeza;
    private ImageView pierna_DER;
    private ImageView pierna_IZQ;
    private ImageView brazo_DER;
    private ImageView brazo_IZQ;
    private ImageView torso;
    private ImageView cabeza_Ondo;
    private ImageView pierna_DER_Ondo;
    private ImageView pierna_IZQ_Ondo;
    private ImageView brazo_DER_Ondo;
    private ImageView brazo_IZQ_Ondo;
    private ImageView torso_Ondo;
    private int puntuazioa;
    private TextView puntuazioaErakutsi;
    private Handler handler = new Handler();
    private ZatiTxo zatiTxo;
    List<Argazki> gorputza;
    List<Argazki> goruptzaOndo;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jolasa_gune_4, container, false);
        // Inflate the layout for this fragment
        //ikaslearen puntuaketa kalkulatzeko atributuak
        puntuazioa = 1000;
        puntuazioaErakutsi = view.findViewById(R.id.txt_puntuazioa_4);

        //irudiak deklaratu
        cabeza = view.findViewById(R.id.cabeza);
        pierna_DER = view.findViewById(R.id.pierna_DER);
        pierna_IZQ = view.findViewById(R.id.pierna_IZQ);
        brazo_DER = view.findViewById(R.id.brazo_DER);
        brazo_IZQ = view.findViewById(R.id.brazo_IZQ);
        torso = view.findViewById(R.id.torso);

        cabeza_Ondo = view.findViewById(R.id.cabeza_Ondo);
        pierna_DER_Ondo = view.findViewById(R.id.pierna_DER_Ondo);
        pierna_IZQ_Ondo = view.findViewById(R.id.pierna_IZQ_Ondo);
        brazo_DER_Ondo = view.findViewById(R.id.brazo_DER_Ondo);
        brazo_IZQ_Ondo = view.findViewById(R.id.brazo_IZQ_Ondo);
        torso_Ondo = view.findViewById(R.id.torso_Ondo);

        gorputza = new ArrayList<Argazki>(6);
        goruptzaOndo = new ArrayList<Argazki>(6);


        gorputza.clear();
        agazkiakKargatu(gorputza,1, cabeza);
        agazkiakKargatu(gorputza,2, pierna_DER);
        agazkiakKargatu(gorputza,3, pierna_IZQ);
        agazkiakKargatu(gorputza,4, brazo_DER);
        agazkiakKargatu(gorputza,5, brazo_IZQ);
        agazkiakKargatu(gorputza,6, torso);
        goruptzaOndo.clear();
        agazkiakKargatu(goruptzaOndo, 1, cabeza_Ondo);
        agazkiakKargatu(goruptzaOndo, 2, pierna_DER_Ondo);
        agazkiakKargatu(goruptzaOndo, 3, pierna_IZQ_Ondo);
        agazkiakKargatu(goruptzaOndo, 4, brazo_DER_Ondo);
        agazkiakKargatu(goruptzaOndo, 5, brazo_IZQ_Ondo);
        agazkiakKargatu(goruptzaOndo, 6, torso_Ondo);

        zatiTxo = view.findViewById(R.id.zatiTxo);
        ImageView img_correcto = view.findViewById(R.id.img_correcto);
        zatiTxo.setImg_correcto(img_correcto);

        zatiTxo.setGorputza(gorputza);
        zatiTxo.setGorputzaOndo(goruptzaOndo);

        //puntuaketari segunduro 10 puntu kentzeko metodoa
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!zatiTxo.isJolasa_amaituta() && puntuazioa>0){
                    puntuazioa -= 10;
                    puntuazioaErakutsi.setText("Puntuazioa: "+String.valueOf(puntuazioa));
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);

        return view;
    }

    private void agazkiakKargatu(List<Argazki> argazkiak,int bikote, ImageView argazki){

            ViewTreeObserver viewTreeObserver = argazki.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if(argazkiak.size()<6) {
                        int[] locationOnScreen = new int[2];
                        argazki.getLocationOnScreen(locationOnScreen);
                        Argazki argazki_obj = new Argazki(argazki, bikote, argazki.getHeight(), argazki.getWidth(), locationOnScreen[0], locationOnScreen[1]);
                        argazkiak.add(argazki_obj);
                    }
                }
            });
        }
}
