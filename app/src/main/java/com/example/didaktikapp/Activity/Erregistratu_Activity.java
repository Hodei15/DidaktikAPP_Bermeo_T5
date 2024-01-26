package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didaktikapp.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class Erregistratu_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText txt_erregistro_erabiltzaile;
    private EditText txt_erregistro_mail;
    private EditText txt_erregistro_pass;
    private EditText txt_erregistro_pass_ber;
    private Button btn_erregistratu;
    private TextView lbl_login_nav;

    //SharedPreferences
    SharedPreferences sharedpreferences;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erregistratu);
        //Errotazioa blokeatzen du
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        // getting the data which is stored in shared preferences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        //EditText deklarazio
        txt_erregistro_erabiltzaile = findViewById(R.id.txt_erregistro_erabiltzaile);
        txt_erregistro_mail = findViewById(R.id.txt_erregistro_mail);
        txt_erregistro_pass = findViewById(R.id.txt_erregistro_pass);
        txt_erregistro_pass_ber = findViewById(R.id.txt_erregistro_pass_ber);

        //Botoiak
        btn_erregistratu = findViewById(R.id.btn_erregistratu);
        lbl_login_nav = findViewById(R.id.lbl_login_nav);

        btn_erregistratu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txt_erregistro_erabiltzaile.getText().toString().isEmpty() && !txt_erregistro_mail.getText().toString().isEmpty() && !txt_erregistro_pass.getText().toString().isEmpty() && !txt_erregistro_pass_ber.getText().toString().isEmpty()){
                    if(!txt_erregistro_pass.getText().toString().equals(txt_erregistro_pass_ber.getText().toString())){
                        Toast.makeText(Erregistratu_Activity.this, "Pasahitzak ez dira berdinak.", Toast.LENGTH_SHORT).show();
                    }else{
                        erregistratu(txt_erregistro_mail.getText().toString(),txt_erregistro_pass.getText().toString());
                    }
                }else{
                    Toast.makeText(Erregistratu_Activity.this, "Eremu guztiak bete behar dituzu.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lbl_login_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Erregistratu_Activity.this,Login_Activity.class);
                startActivity(i);
            }
        });
    }

    private void erregistratu(String erabiltzaile, String pasahitza) {

        mAuth.createUserWithEmailAndPassword(erabiltzaile, pasahitza)
                .addOnCompleteListener(Erregistratu_Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Si el registro en authentication es correcto
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            //Datuak SharedPreferences-ean gordetzen ditugu
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(EMAIL_KEY, erabiltzaile);
                            editor.putString(PASSWORD_KEY, pasahitza);
                            editor.apply();

                            Toast.makeText(Erregistratu_Activity.this, "Erabiltzailea erregistratu da.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Erregistratu_Activity.this, Menu_Gune_Activity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            if(task.getException().getLocalizedMessage().toString().equals("The email address is already in use by another account.")) {
                                Toast.makeText(Erregistratu_Activity.this, "E-mail hau erregistratuta dago.",Toast.LENGTH_SHORT).show();
                            }else if(task.getException().getLocalizedMessage().toString().equals("The email address is badly formatted.")){
                                Toast.makeText(Erregistratu_Activity.this, "E-mail okerra.",Toast.LENGTH_SHORT).show();
                            }else if(task.getException().getLocalizedMessage().toString().equals("The given password is invalid. [ Password should be at least 6 characters ]")){
                                Toast.makeText(Erregistratu_Activity.this, "Pasahitza 6 karaktere izan behar ditu.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
        });
    }

}