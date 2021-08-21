package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.haui.phamdai.silentmoon.R;

public class Music2Activity extends AppCompatActivity {

    ImageButton ibtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);

        ibtnExit = findViewById(R.id.imageButtonExit_MusicV2);

        ibtnExit.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("menuId", R.id.action_meditate);
            startActivity(intent);
        });
    }
}