package com.example.bankingapp.Activities;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.bankingapp.R;

public class WelcomeSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            Intent intent = new Intent(WelcomeSplashScreen.this,Getstarted.class);
            startActivity(intent);
            finish();
        },3500);
    }
}