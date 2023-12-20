package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.didaktikapp.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.io.File;

public class Menu_Gune_Activity extends AppCompatActivity {

    Button btn_gune_1;
    Button btn_gune_2;
    Button btn_gune_3;
    MapView mapa;

    IMapController controlMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gune);

        btn_gune_1 = findViewById(R.id.btn_gune_1);
        btn_gune_2 = findViewById(R.id.btn_gune_2);
        btn_gune_3 = findViewById(R.id.btn_gune_3);
        mapa = findViewById(R.id.mapaGPS);
        mapa.setTileSource(TileSourceFactory.MAPNIK);

        controlMapa = mapa.getController();
        controlMapa.setZoom(15.0);
        GeoPoint startPoint = new GeoPoint(37.7749, -122.4194);
        controlMapa.setCenter(startPoint);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

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