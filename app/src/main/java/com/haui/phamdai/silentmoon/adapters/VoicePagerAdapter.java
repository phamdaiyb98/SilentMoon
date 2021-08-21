package com.haui.phamdai.silentmoon.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.haui.phamdai.silentmoon.enums.VoiceEnum;
import com.haui.phamdai.silentmoon.fragments.voice.FemaleVoiceFragment;
import com.haui.phamdai.silentmoon.fragments.voice.MaleVoiceFragment;

public class VoicePagerAdapter extends FragmentStatePagerAdapter {

    private final int ITEM = 2;

    public VoicePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MaleVoiceFragment();
        }
        return new FemaleVoiceFragment();
    }

    @Override
    public int getCount() {
        return ITEM;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = VoiceEnum.MALE.name();
        if (position == 1) {
            title = VoiceEnum.FEMALE.name();
        }
        return title;
    }
}
