package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.haui.phamdai.silentmoon.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.buttonGetStarted_Welcome).setOnClickListener(v -> {
            Intent intent = new Intent(this, ChooseTopicActivity.class);
            startActivity(intent);
        });
    }
}