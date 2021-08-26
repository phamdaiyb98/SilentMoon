package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.haui.phamdai.silentmoon.R;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnGetStarted;
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 18) {
            setContentView(R.layout.activity_welcome);
            btnGetStarted = findViewById(R.id.buttonGetStarted_Welcome);
        } else {
            setContentView(R.layout.activity_welcome_sleep);
            btnGetStarted = findViewById(R.id.buttonGetStarted_WelcomeSleep);
        }

        btnGetStarted.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignInAndSignUpActivity.class);
            startActivity(intent);
        });
    }
}