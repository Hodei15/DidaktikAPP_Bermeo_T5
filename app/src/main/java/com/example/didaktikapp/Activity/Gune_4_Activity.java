package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.didaktikapp.Fragments.Audio_Fragment_Gune_5;
import com.example.didaktikapp.Fragments.Bideo_Fragment_Gune_4;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_4;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_5;
import com.example.didaktikapp.R;

public class Gune_4_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_4);
        Button btn_atzera =findViewById(R.id.btn_atzera);
        Button btn_aurrera = findViewById(R.id.btn_aurrera);
        Button g4_boton_home = findViewById(R.id.g2_boton_home);
        TextView lbl_portua = findViewById(R.id.lbl_portua);

        g4_boton_home.bringToFront();
        lbl_portua.bringToFront();
        g4_boton_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gune_4_Activity.this, Menu_Gune_Activity.class);

                startActivity(intent);
            }
        });
        btn_atzera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo= new Bideo_Fragment_Gune_4();
                if (fragment instanceof Bideo_Fragment_Gune_4){
                    //Falta por programar
                }else if(fragment instanceof Jolasa_Fragment_Gune_4) {
                    fragment_nuevo = new Bideo_Fragment_Gune_4();
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });

        btn_aurrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment Manager
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment fragment = fm.findFragmentById(R.id.frag_container);

                Fragment fragment_nuevo= new Bideo_Fragment_Gune_4();
                if (fragment instanceof Bideo_Fragment_Gune_4){
                    fragment_nuevo = new Jolasa_Fragment_Gune_4();
                }else if(fragment instanceof Jolasa_Fragment_Gune_4){
                    fragment_nuevo = new Bideo_Fragment_Gune_4();
                    Intent i = new Intent(Gune_4_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                    //Falta por programar
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });
    }
}