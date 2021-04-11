package com.example.bankingapp.Activities;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.bankingapp.R;

public class SuccessSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(() -> {

            Intent intent = new Intent(SuccessSplashScreen.this, TransactionHistoryActivity.class);
            startActivity(intent);
            finish();
        },4000);
    }
}