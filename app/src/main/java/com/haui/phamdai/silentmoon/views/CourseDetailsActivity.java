package com.haui.phamdai.silentmoon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.adapters.VoicePagerAdapter;

public class CourseDetailsActivity extends AppCompatActivity {

    TabLayout tabLayoutVoice;
    ViewPager viewPagerVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        tabLayoutVoice = findViewById(R.id.tabLayoutVoice);
        viewPagerVoice = findViewById(R.id.viewPagerVoice);

        findViewById(R.id.buttonBack_CourseDetails).setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        FragmentManager manager = getSupportFragmentManager();
        VoicePagerAdapter pageAdapter = new VoicePagerAdapter(manager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPagerVoice.setAdapter(pageAdapter);
        tabLayoutVoice.setupWithViewPager(viewPagerVoice, true);

        viewPagerVoice.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutVoice));
        tabLayoutVoice.setTabsFromPagerAdapter(pageAdapter);
        tabLayoutVoice.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerVoice));
    }
}