package com.example.didaktikapp.Activity;

import static com.example.didaktikapp.Activity.Login_Activity.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.Fragments.Argazkiak_Fragment_Gune_2;
import com.example.didaktikapp.Fragments.Bideo_Fragment_Gune_2;
import com.example.didaktikapp.R;
import com.google.gson.Gson;

public class Gune_2_Activity extends AppCompatActivity {
    Button btn_home_gune2;
    TextView lbl_arrain;
    SharedPreferences  sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_2);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView img_atzera =findViewById(R.id.img_atzera2);
        ImageView img_aurrera = findViewById(R.id.img_aurrera2);
        btn_home_gune2 = findViewById(R.id.g2_boton_home);
        lbl_arrain = findViewById(R.id.lbl_arrain);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //Erabiltzailea sharedPref-etik lortzen du
        Gson gson = new Gson();
        String json = sharedpreferences.getString("erabiltzaile", "");
        Erabiltzaile erabiltzaile = gson.fromJson(json, Erabiltzaile.class);


        btn_home_gune2.bringToFront();
        lbl_arrain.bringToFront();

        //Etxe botoia
        btn_home_gune2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gune_2_Activity.this, Menu_Gune_Activity.class);

                startActivity(intent);
            }
        });

        //Atzera botoia
        img_atzera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo= new Argazkiak_Fragment_Gune_2();
                if (fragment instanceof Argazkiak_Fragment_Gune_2){
                    Intent i = new Intent(Gune_2_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                }else if(fragment instanceof Bideo_Fragment_Gune_2) {
                    fragment_nuevo = new Argazkiak_Fragment_Gune_2();
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });

        //Aurrera botoia
        img_aurrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo= new Argazkiak_Fragment_Gune_2();
                if (fragment instanceof Argazkiak_Fragment_Gune_2){
                    fragment_nuevo = new Bideo_Fragment_Gune_2();
                }else if(fragment instanceof Bideo_Fragment_Gune_2){
                    Intent i = new Intent(Gune_2_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                }
                if(fragment_nuevo!=null){
                    fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                    fragmentTransaction.commit();
                }else{
                    fragmentTransaction.replace(R.id.frag_container, new Bideo_Fragment_Gune_2());
                    fragmentTransaction.commit();
                }
            }
        });
    }
}