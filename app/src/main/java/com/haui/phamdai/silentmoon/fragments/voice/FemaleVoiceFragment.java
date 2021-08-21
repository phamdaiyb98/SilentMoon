package com.haui.phamdai.silentmoon.fragments.voice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.adapters.VoiceAdapter;
import com.haui.phamdai.silentmoon.models.Voice;

import java.util.ArrayList;
import java.util.List;

public class FemaleVoiceFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_female_voice, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewFemaleVoice);

        recyclerView.setAdapter(new VoiceAdapter(getFemaleVoiceList()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration decoration
                = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);

        return view;
    }

    private List<Voice> getFemaleVoiceList() {
        List<Voice> voiceList = new ArrayList<>();
        voiceList.add(new Voice("Female 1", "10 MIN"));
        voiceList.add(new Voice("Female 2", "5 MIN"));
        voiceList.add(new Voice("Female 3", "3 MIN"));
        voiceList.add(new Voice("Female 4", "10 MIN"));
        voiceList.add(new Voice("Female 5", "10 MIN"));
        voiceList.add(new Voice("Female 6", "10 MIN"));
        return voiceList;
    }
}