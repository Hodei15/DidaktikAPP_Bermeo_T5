package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    Button btn_saioItxi;
    TextView prueba;
    MapView mapa;
    private Datubasea database;
    private List<Gunea> guneak;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private static final int CODIGO_DE_PERMISOS = 1;
    IMapController controlMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gune);

        btn_saioItxi = findViewById(R.id.btn_saioItxi);


        // Baimenak eman diren ala ez baieztatu
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Baimenak emanda hasieratu
            initLocationManager();
        } else {
            // Baimenak ez daude, ezkatu baimena
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, CODIGO_DE_PERMISOS);
        }


        //mapa jarri
        mapa = findViewById(R.id.mapaGPS);
        mapa.setTileSource(TileSourceFactory.MAPNIK);
        //Maparen haseira puntua ezarri
        controlMapa = mapa.getController();
        controlMapa.setZoom(15.65);
        GeoPoint startPoint = new GeoPoint(43.42104, -2.72546);
        controlMapa.setCenter(startPoint);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        //Zooma jarri mapan
        mapa.setBuiltInZoomControls(true);
        mapa.setMultiTouchControls(true);
        /*
        //ElorrietaMarker
        Marker ElorrietaMarker = new Marker(mapa);
        GeoPoint markerElorrieta = new GeoPoint(43.28368, -2.96498);
        ElorrietaMarker.setPosition(markerElorrieta);
        ElorrietaMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        //marker imagen
        Drawable de = ResourcesCompat.getDrawable(getResources(), R.drawable.marker, null);
        Bitmap bitmapElorrieta = ((BitmapDrawable) de).getBitmap();
        Drawable dre = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapElorrieta, (int) (15f * getResources().getDisplayMetrics().density), (int) (15 * getResources().getDisplayMetrics().density), true));
        ElorrietaMarker.setIcon(dre);
        ElorrietaMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
             @Override
             public boolean onMarkerClick(Marker marker, MapView mapView) {
                 Intent intent;
                 intent = new Intent(Menu_Gune_Activity.this, MainActivity.class);
                 startActivity(intent);
                 return false;
             }
        });
        mapa.getOverlays().add(ElorrietaMarker);
*/

        //Guneen koordenadak lortu
        database = Datubasea.getDatabase(getApplicationContext());
        GuneaDao kontserbaGune = database.guneaDao();
        guneak = kontserbaGune.getAllGuneak();

        //Markadoreak jarri
        for (int i = 0; i < guneak.size(); i++) {
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
            mapa.getOverlays().add(startMarker);

            //marker onclick
            startMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker, MapView mapView) {

                    int clickedMarkerIndex = (int) marker.getRelatedObject();

                    // Gunea zabaldu markadorearen arabera
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

            btn_saioItxi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Menu_Gune_Activity.this, Login_Activity.class);
                    startActivity(i);
                }
            });


        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        detenerActualizacionesDeUbicacion();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1500, 1.0f, locationListener);
        }
    }

    public void initLocationManager() {
        // Inicializa el LocationManager y el LocationListener
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Ubikazio berria lortu aldatzerakoan
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();


                //prueba.setText("latitude:" +latitude+ ", longitude: "+longitude);

                System.out.println(latitude);
                System.out.println(longitude);

                // Puedes actualizar el mapa o hacer lo que necesites con las nuevas coordenadas
                GeoPoint currentLocation = new GeoPoint(latitude, longitude);
                controlMapa.setCenter(currentLocation);
                /*
                float distancia = location.distanceTo(new Location(LocationManager.GPS_PROVIDER) {{
                    setLatitude(43.28368);
                    setLongitude(-2.96498);
                }});
                float margenDistancia = 50.0f;
                // Si la distancia es menor que el umbral, muestra la notificación
                if (distancia < margenDistancia) {
                    Intent intent;
                    intent = new Intent(Menu_Gune_Activity.this, Login_Activity.class);
                    startActivity(intent);
                    Toast.makeText(Menu_Gune_Activity.this, "Has llegado a tu destino", Toast.LENGTH_SHORT).show();
                }*/
                int j;
                // Comprobar distancia a los marcadores generados dinámicamente
                for (j = 0; j < guneak.size(); j++) {
                    final int markerIndex = j;
                    float distanciaMarker = location.distanceTo(new Location(LocationManager.GPS_PROVIDER) {{
                        setLatitude(guneak.get(markerIndex).lat);
                        setLongitude(guneak.get(markerIndex).lon);
                    }});
                    float margenDistanciaMarker = 50.0f;
                    if (distanciaMarker < margenDistanciaMarker) {
                        // Llegaste al marcador i
                        Intent intent;
                        switch (j) {
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
                            case 5:
                                intent = new Intent(Menu_Gune_Activity.this, Gune_1_Activity.class);
                                break;


                            default:
                                intent = new Intent(Menu_Gune_Activity.this, MainActivity.class);
                                break;
                        }
                        startActivity(intent);
                        Toast.makeText(Menu_Gune_Activity.this, "Has llegado a tu destino" + guneak.get(j).izena, Toast.LENGTH_SHORT).show();
                    }
                }
            }

        };

        //Baimenak eskatu
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1500, 1.0f, locationListener);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CODIGO_DE_PERMISOS) {
            // Baimenak eman dira ala ez
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido
                initLocationManager();
            } else {
                // Permiso denegado.
                Intent i = new Intent(Menu_Gune_Activity.this, Login_Activity.class);
                startActivity(i);
            }
        }
    }
    private void detenerActualizacionesDeUbicacion() {
        if (locationManager != null && locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }
}