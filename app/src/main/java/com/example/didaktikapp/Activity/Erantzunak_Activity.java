package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

public class Erantzunak_Activity extends AppCompatActivity {

    ArrayAdapter<String> guneakAdaptadorea;
    Spinner guneak_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erantzunak);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        guneak_spinner = findViewById(R.id.spinner_galderak);

        List<String> guneak = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, guneak);

        guneakAdaptadorea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guneak_spinner.setAdapter(guneakAdaptadorea);

        guneak.add("Gune 1");
        guneak.add("Gune 2");
        guneak.add("Gune 3");
        guneak.add("Gune 4");
        guneak.add("Gune 5");

        adapter.notifyDataSetChanged();


    }
}