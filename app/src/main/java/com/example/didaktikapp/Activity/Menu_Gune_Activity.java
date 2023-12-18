package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.didaktikapp.R;

public class Menu_Gune_Activity extends AppCompatActivity {

    Button btn_gune_1;
    Button btn_gune_2;
    Button btn_gune_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gune);

        btn_gune_1 = findViewById(R.id.btn_gune_1);
        btn_gune_2 = findViewById(R.id.btn_gune_2);
        btn_gune_3 = findViewById(R.id.btn_gune_3);

        btn_gune_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_Gune_Activity.this, Gune_1_Activity.class);
                startActivity(i);
            }
        });

        btn_gune_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_Gune_Activity.this, Gune_2_Activity.class);
                startActivity(i);
            }
        });
        btn_gune_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu_Gune_Activity.this, Gune_3_Activity.class);
                startActivity(i);
            }
        });

    }
}