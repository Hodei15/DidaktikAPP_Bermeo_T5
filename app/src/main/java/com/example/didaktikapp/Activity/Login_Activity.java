package com.example.didaktikapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Database.Dao.ErabiltzaileDao;
import com.example.didaktikapp.Database.Dao.GuneaDao;
import com.example.didaktikapp.Database.Datubasea;
import com.example.didaktikapp.Database.Erabiltzaile;
import com.example.didaktikapp.Database.Erantzuna;
import com.example.didaktikapp.Database.Galdera;
import com.example.didaktikapp.Database.Gunea;
import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.Database.Jarduera;
import com.example.didaktikapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import android.content.Context;

import java.time.chrono.Era;
import java.util.List;

public class Login_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText txt_login_erabiltzaile;
    private EditText txt_login_pasahitza;
    private Button btn_sartu;
    private TextView lbl_erregistratu_nav;
    private String email;
    private String pass;
    private Datubasea database;
    private List<Gunea> guneak;
    private List<Jarduera> jardueak;
    private List<Galdera> galderak;
    private List<Erantzuna> erantzunak;
    private Erabiltzaile erabiltzailea;
    int lehenAldia = 0;
    private Button erantzunak_erakutsi;

    //SharedPreferences
    SharedPreferences sharedpreferences;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";
    public static final String LEHEN_ALDIA = "lehenAldia";

    final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        database = Datubasea.getDatabase(getApplicationContext());

        ErabiltzaileDao erabiltzaileDao = database.erabiltzaileDao();

        List<Erabiltzaile> usuarios = erabiltzaileDao.getAllErabiltzaileak();

        //Firebase
        mAuth = FirebaseAuth.getInstance();
        // getting the data which is stored in shared preferences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        email = sharedpreferences.getString(EMAIL_KEY, null);
        pass = sharedpreferences.getString(PASSWORD_KEY, null);

        if(sharedpreferences.getInt(LEHEN_ALDIA, 0)==0) {
            lehenAldia = sharedpreferences.getInt(LEHEN_ALDIA, -1);
        }
        //Lehen exekuzioa bada konprobatzen du
        if(lehenAldia!=0) {
            //Datuak SharedPreferences-ean gordetzen ditugu
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt(LEHEN_ALDIA, 0);
            guneak = Metodoak.guneakBete(database);
            jardueak = Metodoak.jardueraBete(database);
            galderak = Metodoak.GalderakBete(database);
            editor.apply();
        }

        //Erantzunak eta erabiltzaileak kargatzen dira
        Metodoak.erabiltzaileKargatu(db,database);

        //EditText deklarazio
        txt_login_erabiltzaile = findViewById(R.id.txt_login_erabiltzaile);
        txt_login_pasahitza = findViewById(R.id.txt_login_pasahitza);
        //Balioak jarri
        txt_login_erabiltzaile.setText(email);
        txt_login_pasahitza.setText(pass);

        //botoiak
        btn_sartu = findViewById(R.id.btn_sartu);
        lbl_erregistratu_nav = findViewById(R.id.lbl_erregistratu_nav);
        erantzunak_erakutsi = findViewById(R.id.btn_Irakaslea);

        //BOTONES (eventos)
        //login
        btn_sartu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String erabiltzaile = txt_login_erabiltzaile.getText().toString().trim();
                    String pasahitza = txt_login_pasahitza.getText().toString().trim();


                    if (erabiltzaile.isEmpty()) {
                        String sartuEposta = getResources().getString(R.string.Login_editxt_email_hint);
                        txt_login_erabiltzaile.setError(sartuEposta);
                    } else if (pasahitza.isEmpty()) {
                        String sartuPasahitza = getResources().getString(R.string.Login_editxt_pasahitza_hint);
                        txt_login_pasahitza.setError(sartuPasahitza);
                    } else {
                        saioaHasi(erabiltzaile, pasahitza);
                    }

                }
        });
        //irakaslea ikusi dezan erantzunak
        erantzunak_erakutsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Erantzunak_Activity.class);
                startActivity(intent);
            }
        });
        //erregistratu nabegazio
        lbl_erregistratu_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Erregistratu_Activity.class);
                startActivity(intent);

            }
        });
    }
    //METODOS

    /**
     * Erabiltzailea zuzena bada logeatzen da
     * @param erabiltzaile_string Erabiltzaile email
     * @param pasahitza Erabiltzaile pasahitza
     */
    private void saioaHasi(String erabiltzaile_string, String pasahitza) {

        mAuth.signInWithEmailAndPassword(erabiltzaile_string, pasahitza)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Saioa ondo hasi da
                            FirebaseUser user = mAuth.getCurrentUser();

                            // Hurrengo lehiora pasatzen da
                            Intent intent = new Intent(Login_Activity.this, Menu_Gune_Activity.class);

                            //Datuak SharedPreferences-ean gordetzen ditugu
                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString(EMAIL_KEY, erabiltzaile_string);
                            editor.putString(PASSWORD_KEY, pasahitza);

                            Erabiltzaile erabiltzaile = Metodoak.erabiltzaileaLortu(database,erabiltzaile_string);
                            String json = gson.toJson(erabiltzaile);
                            editor.putString("erabiltzaile", json);

                            editor.apply();

                            startActivity(intent);
                            finish();

                        //Saioko erroreak(email okerra, pasahitza okerra, no conection...)
                        } else {
                            if(task.getException().getLocalizedMessage().toString().equals("The email address is already in use by another account.")) {
                                Toast.makeText(Login_Activity.this, "E-mail hau erregistratuta dago.",Toast.LENGTH_SHORT).show();
                            }else if(task.getException().getLocalizedMessage().toString().equals("The email address is badly formatted.")){
                                Toast.makeText(Login_Activity.this, "E-mail okerra.",Toast.LENGTH_SHORT).show();
                            }else if(task.getException().getLocalizedMessage().toString().equals("The given password is invalid. [ Password should be at least 6 characters ]")){
                                Toast.makeText(Login_Activity.this, "Pasahitza 6 karaktere izan behar ditu.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
        });
    }


}