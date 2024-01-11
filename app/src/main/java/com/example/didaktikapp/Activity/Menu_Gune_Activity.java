package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Gunea;
import com.example.didaktikapp.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.File;
import java.util.List;

public class Menu_Gune_Activity extends AppCompatActivity {

    Button btn_gune_1;
    Button btn_gune_2;
    Button btn_gune_3;
    MapView mapa;
    private Datubasea database;
    private List<Gunea> guneak;


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
        controlMapa.setZoom(15.65);
        GeoPoint startPoint = new GeoPoint(43.42104, -2.72546);
        controlMapa.setCenter(startPoint);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        mapa.setBuiltInZoomControls(true);
        mapa.setMultiTouchControls(true);


        database = Datubasea.getDatabase(getApplicationContext());
        GuneaDao kontserbaGune = database.guneaDao();
        guneak = kontserbaGune.getAllGuneak();


        for (int i = 0;i<guneak.size();i++){
            final int markerIndex = i;
            //marker
            Marker startMarker = new Marker(mapa);
            GeoPoint marker = new GeoPoint(guneak.get(i).lat, guneak.get(i).lon);
            startMarker.setPosition(marker);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);

            //marker imagen
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.marker, null);
            Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
            Drawable dr = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, (int) (15f * getResources().getDisplayMetrics().density), (int) (15 * getResources().getDisplayMetrics().density), true));
            startMarker.setIcon(dr);
            mapa.getOverlays().add(startMarker);
            // Indexatu marker
            startMarker.setRelatedObject(markerIndex);
            //marker onclick
            startMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker, MapView mapView) {

                    int clickedMarkerIndex = (int) marker.getRelatedObject();

                    // Abre la actividad correspondiente según el identificador único
                    Intent intent;
                    switch (clickedMarkerIndex) {
                        case 0:
                            intent = new Intent(Menu_Gune_Activity.this, Gune_1_Activity.class);
                            break;
                        case 1:
                            intent = new Intent(Menu_Gune_Activity.this, Gune_2_Activity.class);
                            break;
                        case 2:
                            intent = new Intent(Menu_Gune_Activity.this, Gune_3_Activity.class);
                            break;
                        case 3:
                            intent = new Intent(Menu_Gune_Activity.this, Gune_4_Activity.class);
                            break;
                        case 4:
                            intent = new Intent(Menu_Gune_Activity.this, Gune_5_Activity.class);
                            break;

                        default:
                            intent = new Intent(Menu_Gune_Activity.this, MainActivity.class);
                            break;
                    }
                    startActivity(intent);
                    return false;
                }
            });
            //markadoreak gehitu mapara
            mapa.getOverlays().add(startMarker);
        }




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