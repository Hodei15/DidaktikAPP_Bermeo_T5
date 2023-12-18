package com.example.didaktikapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.didaktikapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Sortu intent bat login hasteko
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(intent);
                finish(); // Honek MainActivity ixten du, erabiltzaileak Atzera botoia erabiliz bertara itzultzea nahi ez baduzu.
            }
        }, 1000); // zenbat denbora irauten duen aldatzen 1sg = 1000
    }
}