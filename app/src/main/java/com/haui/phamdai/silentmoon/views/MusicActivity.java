package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.haui.phamdai.silentmoon.R;

public class MusicActivity extends AppCompatActivity {

    ImageButton ibtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ibtnExit = findViewById(R.id.imageButtonExit_Music);

        ibtnExit.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayOptionActivity.class);
            intent.putExtra("data", getIntent().getSerializableExtra("data"));
            startActivity(intent);
        });
    }
}