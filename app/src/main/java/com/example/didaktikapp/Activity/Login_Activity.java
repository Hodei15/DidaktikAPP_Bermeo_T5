package com.example.didaktikapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.didaktikapp.Database.Gunea;
import com.example.didaktikapp.Controler.Metodoak;
import com.example.didaktikapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.content.Context;

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
    int lehenAldia = 0;

    //SharedPreferences
    SharedPreferences sharedpreferences;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";
    public static final String LEHEN_ALDIA = "lehenAldia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        //EditText deklarazio
        txt_login_erabiltzaile = findViewById(R.id.txt_login_erabiltzaile);
        txt_login_pasahitza = findViewById(R.id.txt_login_pasahitza);
        //Balioak jarri
        txt_login_erabiltzaile.setText(email);
        txt_login_pasahitza.setText(pass);

        //botoiak
        btn_sartu = findViewById(R.id.btn_sartu);
        lbl_erregistratu_nav = findViewById(R.id.lbl_erregistratu_nav);

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
    private void saioaHasi(String erabiltzaile, String pasahitza) {

        mAuth.signInWithEmailAndPassword(erabiltzaile, pasahitza)
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

                            if(lehenAldia!=0) {
                                guneak = Metodoak.guneakBete(database);
                                editor.putInt(LEHEN_ALDIA, 0);
                            }

                            editor.putString(EMAIL_KEY, erabiltzaile);
                            editor.putString(PASSWORD_KEY, pasahitza);
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