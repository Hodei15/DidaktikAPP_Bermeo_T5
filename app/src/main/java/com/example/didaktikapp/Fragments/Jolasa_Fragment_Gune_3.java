package com.example.didaktikapp.Fragments;

import static android.service.controls.ControlsProviderService.TAG;

import static com.example.didaktikapp.Activity.Login_Activity.SHARED_PREFS;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.Model.EsperaImagen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.example.didaktikapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jolasa_Fragment_Gune_3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_3 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_3 fragment = new Jolasa_Fragment_Gune_3();
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
        return inflater.inflate(R.layout.fragment_jolasa_gune_3, container, false);
    }
    ImageView mural;
    double argazkiZabalera;
    double argazkiAltuera;

    ArrayList<String> galderak;
    ArrayList<String> koordenadak;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    int galdera_index;
    TextView lbl_galdera_jolasa_3;
    private FirebaseAuth mAuth;
    double hasiera_x;
    double hasiera_y;
    ImageView img_tick_jolasa3;
    ImageView img_borobil_1;
    ImageView img_borobil_2;
    ImageView img_borobil_3;
    ImageView img_borobil_4;
    ImageView img_borobil_5;
    private int puntuazioa;
    private TextView puntuazioaErakutsi;
    private Handler handler = new Handler();
    boolean jolasa_amaituta = false;
    SharedPreferences sharedpreferences;
    private Datubasea database;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        //Room datubasearen instantzia lortu
        database = Datubasea.getDatabase(getActivity().getApplicationContext());
        //atributuak deklaratu
        sharedpreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //Erabiltzailea sharedPref-etik lortzen du
        Gson gson = new Gson();
        String json = sharedpreferences.getString("erabiltzaile", "");
        Erabiltzaile erabiltzaile = gson.fromJson(json, Erabiltzaile.class);

        //ikaslearen puntuaketa kalkulatzeko atributuak
        puntuazioa = 1000;
        puntuazioaErakutsi = view.findViewById(R.id.txt_puntuazioa_3);


        //atributuak deklaratu
        mural = (ImageView) view.findViewById(R.id.Murala);
        lbl_galdera_jolasa_3 = view.findViewById(R.id.lbl_galdera_jolasa_3);
        img_tick_jolasa3 = view.findViewById(R.id.img_tick_jolasa3);
        img_borobil_1 = view.findViewById(R.id.img_borobil_1);
        img_borobil_2 = view.findViewById(R.id.img_borobil_2);
        img_borobil_3 = view.findViewById(R.id.img_borobil_3);
        img_borobil_4 = view.findViewById(R.id.img_borobil_4);
        img_borobil_5 = view.findViewById(R.id.img_borobil_5);

        mAuth = FirebaseAuth.getInstance();
        db.collection("guneak").document("gune_3").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                galderak = (ArrayList<String>) document.get("galderak");
                koordenadak = (ArrayList<String>) document.get("koordenadak");
                lbl_galdera_jolasa_3.setText(galderak.get(0));
                galdera_index = 0;
            }
        });

        ViewTreeObserver viewTreeObserver = mural.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] locationOnScreen = new int[2];
                mural.getLocationOnScreen(locationOnScreen);
                argazkiZabalera = mural.getWidth();
                argazkiAltuera = mural.getHeight();
                Log.d(TAG,"Finish X: "+ argazkiAltuera);
                Log.d(TAG,"Finish y: "+ argazkiZabalera);
            }
        });
        mural.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float clicX = event.getX();
                float clicY = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        hasiera_x = clicX;
                        hasiera_y = clicY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        if(hasiera_x>= Double.parseDouble(koordenadak.get(galdera_index).split("/")[0]) - 50 && hasiera_x<= Double.parseDouble(koordenadak.get(galdera_index).split("/")[0]) + 50 && hasiera_y>= Double.parseDouble(koordenadak.get(galdera_index).split("/")[1]) - 50 && hasiera_y<= Double.parseDouble(koordenadak.get(galdera_index).split("/")[1]) + 50){
                            img_tick_jolasa3.setImageResource(R.drawable.tick);
                            EsperaImagen espera = new EsperaImagen(img_tick_jolasa3);
                            img_tick_jolasa3.setVisibility(View.VISIBLE);

                            switch (galdera_index){
                                case 0:
                                    img_borobil_1.setVisibility(View.VISIBLE);
                                    break;
                                case 1:
                                    img_borobil_2.setVisibility(View.VISIBLE);
                                    break;
                                case 2:
                                    img_borobil_3.setVisibility(View.VISIBLE);
                                    break;
                                case 3:
                                    img_borobil_4.setVisibility(View.VISIBLE);
                                    break;
                                case 4:
                                    img_borobil_5.setVisibility(View.VISIBLE);
                                    jolasa_amaituta = true;
                                    break;
                            }

                            if(galdera_index<galderak.size()-1) {
                                galdera_index++;
                                lbl_galdera_jolasa_3.setText(galderak.get(galdera_index));
                            }else{
                                lbl_galdera_jolasa_3.setText("Oso ondo!");
                            }
                        }else{
                            img_tick_jolasa3.setImageResource(R.drawable.cruz);
                            EsperaImagen espera = new EsperaImagen(img_tick_jolasa3);
                            img_tick_jolasa3.setVisibility(View.VISIBLE);
                        }
                        break;
                }
                return true;
            }
        });
        //puntuaketari segunduro 10 puntu kentzeko metodoa
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (puntuazioa > 0 && !jolasa_amaituta) {
                    puntuazioa -= 10;
                    puntuazioaErakutsi.setText("Puntuazioa: "+String.valueOf(puntuazioa));
                    handler.postDelayed(this, 1000);
                }else if(jolasa_amaituta){
                    if(Metodoak.erantzunaGordeRoom(database,String.valueOf(puntuazioa),3,erabiltzaile.getId())) {
                        Metodoak.erantzunaFirebaseGorde(String.valueOf(puntuazioa), 3, erabiltzaile.getEmail());
                        Toast.makeText(getActivity(), "Lortutako puntuazioa gorde egin da.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, 1000);
    }
}