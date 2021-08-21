package com.haui.phamdai.silentmoon.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.haui.phamdai.silentmoon.views.SleepContainerFragment;
import com.haui.phamdai.silentmoon.fragments.home.HomeFragment;
import com.haui.phamdai.silentmoon.fragments.home.MeditateFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final Bundle receiveScreen;

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior, Bundle receiveScreen) {
        super(fm, behavior);
        this.receiveScreen = receiveScreen;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                SleepContainerFragment containerFragment = new SleepContainerFragment();
                containerFragment.setArguments(receiveScreen);
                return containerFragment;
            case 2:
                return new MeditateFragment();
//            case 3: return new ;
//            case 4: return new ;
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

}
