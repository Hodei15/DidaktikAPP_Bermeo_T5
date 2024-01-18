package com.example.didaktikapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.didaktikapp.Activity.Gune_1_Activity;
import com.example.didaktikapp.Activity.Menu_Gune_Activity;
import com.example.didaktikapp.R;

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
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        int tamañoX = Arrantza_Ontzia_C1.getDrawable().getIntrinsicWidth();
        int tamañoY = Arrantza_Ontzia_C1.getDrawable().getIntrinsicHeight();
        Arrantza_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Arrantza_Ontzia_C1.setImageResource(R.drawable.arrantza_ontzia);
                ViewGroup.LayoutParams layoutParams = Arrantza_Ontzia_C1.getLayoutParams();
                layoutParams.width = tamañoX;
                layoutParams.height = tamañoY;
                Arrantza_Ontzia_C1.setLayoutParams(layoutParams);
            }
        });
        Arrantza_Ontzia_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Arrantza_Ontzia_C2.setImageResource(R.drawable.arrantza_ontzia);
            }
        });
        Garraio_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Garraio_Ontzia_C1.setImageResource(R.drawable.garraio_ontzia);
            }
        });
        Garraio_Ontzia_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Garraio_Ontzia_C2.setImageResource(R.drawable.garraio_ontzia);
            }
        });
        Bela_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bela_Ontzia_C1.setImageResource(R.drawable.belaontzia);
            }
        });
        Bela_Ontzia_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bela_Ontzia_C2.setImageResource(R.drawable.belaontzia);
            }
        });
        Bale_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bale_Ontzia_C1.setImageResource(R.drawable.baleontzia);
            }
        });
        Bale_Ontzia_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bale_Ontzia_C2.setImageResource(R.drawable.baleontzia);
            }
        });
        Txalupa_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Txalupa_C1.setImageResource(R.drawable.txalupa);
            }
        });
        Txalupa_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Txalupa_C2.setImageResource(R.drawable.txalupa);
            }
        });
        Arraun_Ontzia_C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Arraun_Ontzia_C1.setImageResource(R.drawable.arraun_ontzia);
            }
        });
        Arraun_Ontzia_C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Arraun_Ontzia_C2.setImageResource(R.drawable.arraun_ontzia);
            }
        });
    }
}