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

import com.example.didaktikapp.Fragments.Audio_Fragment_Gune_5;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_5;
import com.example.didaktikapp.R;

public class Gune_5_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_5);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView img_atzera =findViewById(R.id.img_atzera5);
        ImageView img_aurrera = findViewById(R.id.img_aurrera5);
        Button g5_boton_home = findViewById(R.id.g2_boton_home);
        TextView lbl_itsasontzi = findViewById(R.id.lbl_itsasontziak);

        g5_boton_home.bringToFront();
        lbl_itsasontzi.bringToFront();

        //Etxe botoia
        g5_boton_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gune_5_Activity.this, Menu_Gune_Activity.class);
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

                Fragment fragment_nuevo= new Audio_Fragment_Gune_5();
                if (fragment instanceof Audio_Fragment_Gune_5){
                    Intent intent = new Intent(Gune_5_Activity.this, Menu_Gune_Activity.class);
                    startActivity(intent);
                }else if(fragment instanceof Jolasa_Fragment_Gune_5) {
                    fragment_nuevo = new Audio_Fragment_Gune_5();
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

                Fragment fragment_nuevo= new Audio_Fragment_Gune_5();
                if (fragment instanceof Audio_Fragment_Gune_5){
                    fragment_nuevo = new Jolasa_Fragment_Gune_5();
                }else if(fragment instanceof Jolasa_Fragment_Gune_5){
                    fragment_nuevo = new Audio_Fragment_Gune_5();
                    Intent i = new Intent(Gune_5_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });
    }
}