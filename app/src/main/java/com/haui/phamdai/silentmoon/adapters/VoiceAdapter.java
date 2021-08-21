package com.haui.phamdai.silentmoon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.Voice;

import java.util.List;

public class VoiceAdapter extends RecyclerView.Adapter<VoiceAdapter.ViewHolder> {

    private final List<Voice> voiceList;

    public VoiceAdapter(List<Voice> voiceList) {
        this.voiceList = voiceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_voice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Voice voice = voiceList.get(position);

//       TODO: check play or pause
        holder.ivVoid.setImageResource(R.drawable.course_details_bottom_icon_play);
        holder.txtVoiceName.setText(voice.getName());
        holder.txtVoiceTime.setText(voice.getTime());
    }

    @Override
    public int getItemCount() {
        return voiceList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton ivVoid;
        TextView txtVoiceName;
        TextView txtVoiceTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ivVoid = itemView.findViewById(R.id.imageButtonVoice);
            txtVoiceName = itemView.findViewById(R.id.textViewVoiceName);
            txtVoiceTime = itemView.findViewById(R.id.textViewVoiceTime);
        }

    }

}
