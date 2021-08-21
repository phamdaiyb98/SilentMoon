package com.haui.phamdai.silentmoon.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.enums.SleepScreen;
import com.haui.phamdai.silentmoon.fragments.home.SleepFragment;
import com.haui.phamdai.silentmoon.fragments.home.SleepMusicFragment;

public class SleepContainerFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sleep_container, container, false);

        Bundle bundle = getArguments();
//        getSavedStateRegistry();
        SleepScreen screen = SleepScreen.SLEEP_FRAGMENT;
        if (bundle != null) {
            screen = (SleepScreen) bundle.getSerializable("screen");
        }

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        if (screen.equals(SleepScreen.SLEEP_FRAGMENT)) {
            transaction.add(R.id.sleepFragmentContainer, SleepFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        }
        if (screen.equals(SleepScreen.SLEEP_MUSIC_FRAGMENT)) {
            transaction.add(R.id.sleepFragmentContainer, SleepMusicFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        }
        return view;
    }
}