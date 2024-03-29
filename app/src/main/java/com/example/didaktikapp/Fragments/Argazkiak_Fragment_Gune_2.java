package com.example.didaktikapp.Fragments;

import static android.content.Context.MODE_PRIVATE;

import static com.example.didaktikapp.Activity.Login_Activity.SHARED_PREFS;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didaktikapp.Activity.Erregistratu_Activity;
import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.R;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Argazkiak_Fragment_Gune_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Argazkiak_Fragment_Gune_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Argazkiak_Fragment_Gune_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Argazkiak_Fragment_Gune_2.
     */
    // TODO: Rename and change types and number of parameters
    public static Argazkiak_Fragment_Gune_2 newInstance(String param1, String param2) {
        Argazkiak_Fragment_Gune_2 fragment = new Argazkiak_Fragment_Gune_2();
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
        return inflater.inflate(R.layout.fragment_argazkiak_gune_2, container, false);

    }
    Button btn_gorde_erantzuna;
    SharedPreferences sharedpreferences;
    private Datubasea database;
    TextView txt_Argazkiak_Gune2;
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

        txt_Argazkiak_Gune2 = view.findViewById(R.id.txt_Argazkiak_Gune2);
        btn_gorde_erantzuna = view.findViewById(R.id.btn_gorde_erantzuna);

        btn_gorde_erantzuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String erantzuna = txt_Argazkiak_Gune2.getText().toString();
                if(Metodoak.erantzunaGordeRoom(database,erantzuna,2,erabiltzaile.getId())) {
                    Metodoak.erantzunaFirebaseGorde(erantzuna, 2, erabiltzaile.getEmail());
                    Toast.makeText(getActivity(), "Lortutako puntuazioa gorde egin da.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}