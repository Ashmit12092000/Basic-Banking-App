package com.example.bankingapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bankingapp.R;

public class SplashScreenActivity extends AppCompatActivity {
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        pbar=findViewById(R.id.progressBar);
        Handler handler = new Handler();
        handler.postDelayed(() -> {

            Intent intent = new Intent(SplashScreenActivity.this,WelcomeSplashScreen.class);
            startActivity(intent);
            pbar.setVisibility(View.GONE);
            finish();
        },2500);

    }
}

