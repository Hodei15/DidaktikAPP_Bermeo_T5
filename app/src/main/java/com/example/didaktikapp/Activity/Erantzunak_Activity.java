package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.didaktikapp.Database.Dao.ErabiltzaileDao;
import com.example.didaktikapp.Database.Dao.ErantzunaDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

public class Erantzunak_Activity extends AppCompatActivity {

    ArrayAdapter<String> guneakAdaptadorea;
    Spinner guneak_spinner;
    Button btn_bilatu;
    EditText txt_izena;
    EditText txt_abizena;
    EditText txt_klasea;
    TextView txt_erantzuna;
    ImageView btn_atzera_erantzun;
    private Datubasea database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erantzunak);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn_atzera_erantzun = findViewById(R.id.btn_atzera_erantzun);
        guneak_spinner = findViewById(R.id.spinner_galderak);
        btn_bilatu = findViewById(R.id.btn_bilatu);
        txt_izena = findViewById(R.id.txt_izena);
        txt_abizena = findViewById(R.id.txt_abizena);
        txt_klasea = findViewById(R.id.txt_Klasea);
        txt_erantzuna = findViewById(R.id.txt_erantzuna);

        List<String> guneak = new ArrayList<String>();
        guneakAdaptadorea = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, guneak);
        guneakAdaptadorea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guneak_spinner.setAdapter(guneakAdaptadorea);

        guneak.add("Gune 1");
        guneak.add("Gune 2");
        guneak.add("Gune 3");
        guneak.add("Gune 4");
        guneak.add("Gune 5");

        guneakAdaptadorea.notifyDataSetChanged();

        btn_atzera_erantzun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Erantzunak_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });

        btn_bilatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = Datubasea.getDatabase(getApplicationContext());
                ErantzunaDao erantzuna = database.erantzunaDao();
                ErabiltzaileDao erabiltzaileKontroler = database.erabiltzaileDao();
                int opcion = 1+guneak_spinner.getSelectedItemPosition();

                int id_erabiltzaile = erabiltzaileKontroler.getErabiltzaileIdByUsername(txt_izena.getText().toString(),txt_abizena.getText().toString(),txt_klasea.getText().toString());
                String izen = txt_izena.getText().toString();
                String abizen = txt_abizena.getText().toString();
                String klase = txt_klasea.getText().toString();
                String erabiltzaile_erantzun = erantzuna.getErabiltzaileErantzuna(opcion,izen, abizen,klase);
                if(erabiltzaile_erantzun!=null) {
                    txt_erantzuna.setText(txt_izena.getText().toString() + " " + txt_abizena.getText().toString() + "-(r)en erantzuna edo puntuaketa " + opcion + "(-en) gunean: " + erabiltzaile_erantzun);
                }else{
                    txt_erantzuna.setText("Ez da aurkitu datu hauek dituen erantzunik.");
                }
            }
        });
    }
}