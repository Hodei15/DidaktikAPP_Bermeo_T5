package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didaktikapp.Fragments.Audio_Fragment_Gune_3;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_3;
import com.example.didaktikapp.R;

public class Gune_3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_3);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView img_atzera =findViewById(R.id.img_atzera3);
        ImageView img_aurrera = findViewById(R.id.img_aurrera3);
        Button g3_boton_home = findViewById(R.id.g3_boton_home);
        TextView lbl_Saregile = findViewById(R.id.lbl_Saregile);

        g3_boton_home.bringToFront();
        lbl_Saregile.bringToFront();
        g3_boton_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gune_3_Activity.this, Menu_Gune_Activity.class);
                startActivity(intent);
            }
        });

        img_atzera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo=null;
                if (fragment instanceof Audio_Fragment_Gune_3){
                    Intent i = new Intent(Gune_3_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                }else if(fragment instanceof Jolasa_Fragment_Gune_3) {
                    fragment_nuevo = new Audio_Fragment_Gune_3();
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });

        img_aurrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo=null;
                if (fragment instanceof Audio_Fragment_Gune_3){
                    fragment_nuevo = new Jolasa_Fragment_Gune_3();
                }else if(fragment instanceof Jolasa_Fragment_Gune_3){
                    fragment_nuevo = new Audio_Fragment_Gune_3();
                    Intent i = new Intent(Gune_3_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                    //Falta por programar
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });
    }
}