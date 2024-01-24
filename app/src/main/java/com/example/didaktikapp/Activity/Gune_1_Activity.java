package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didaktikapp.Fragments.Audio_Fragment_Gune_1;
import com.example.didaktikapp.Fragments.Bideo_Fragment_Gune_1;
import com.example.didaktikapp.Fragments.Jolasa_Fragment_Gune_1;
import com.example.didaktikapp.R;

public class Gune_1_Activity extends AppCompatActivity {
    boolean gune1 = true;
    Button btn_home_gune1;
    TextView lbl_kontserba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gune_1);

        ImageView img_atzera =findViewById(R.id.img_atzera);
        ImageView img_aurrera = findViewById(R.id.img_aurrera);
        btn_home_gune1 = findViewById(R.id.g2_boton_home);
        lbl_kontserba = findViewById(R.id.lbl_arrain);

        btn_home_gune1.bringToFront();
        lbl_kontserba.bringToFront();
        btn_home_gune1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gune_1_Activity.this, Menu_Gune_Activity.class);

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

                Fragment fragment_nuevo= new Bideo_Fragment_Gune_1();
                if (fragment instanceof Bideo_Fragment_Gune_1){
                    //Falta por programar
                    Intent i = new Intent(Gune_1_Activity.this, Menu_Gune_Activity.class);
                    startActivity(i);
                }else if(fragment instanceof Audio_Fragment_Gune_1) {
                    fragment_nuevo = new Bideo_Fragment_Gune_1();
                }else if(fragment instanceof Jolasa_Fragment_Gune_1){
                    fragment_nuevo = new Audio_Fragment_Gune_1();
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

                Fragment fragment_nuevo= new Bideo_Fragment_Gune_1();
                if (fragment instanceof Bideo_Fragment_Gune_1){
                    fragment_nuevo = new Audio_Fragment_Gune_1();
                }else if(fragment instanceof Audio_Fragment_Gune_1) {
                    fragment_nuevo = new Jolasa_Fragment_Gune_1();
                }else if(fragment instanceof Jolasa_Fragment_Gune_1){
                    Intent i = new Intent(Gune_1_Activity.this,Menu_Gune_Activity.class);
                    startActivity(i);
                }
                fragmentTransaction.replace(R.id.frag_container, fragment_nuevo);
                fragmentTransaction.commit();
            }
        });
    }


}