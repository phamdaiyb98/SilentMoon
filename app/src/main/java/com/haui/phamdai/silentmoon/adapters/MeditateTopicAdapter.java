package com.haui.phamdai.silentmoon.adapters;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.MeditateTopic;

import java.util.List;

public class MeditateTopicAdapter extends RecyclerView.Adapter<MeditateTopicAdapter.ViewHolder> {

    private final List<MeditateTopic> meditateTopicList;
    private final ColorStateList activeColorBtn;
    private final ColorStateList inactiveColorBtn;
    private final ColorStateList activeColorTxt;
    private final ColorStateList inactiveColorTxt;

    public MeditateTopicAdapter(List<MeditateTopic> meditateTopicList,
                                ColorStateList activeColorBtn, ColorStateList inactiveColorBtn,
                                ColorStateList activeColorTxt, ColorStateList inactiveColorTxt) {
        this.meditateTopicList = meditateTopicList;
        this.activeColorBtn = activeColorBtn;
        this.inactiveColorBtn = inactiveColorBtn;
        this.activeColorTxt = activeColorTxt;
        this.inactiveColorTxt = inactiveColorTxt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meditate_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MeditateTopic meditateTopic = meditateTopicList.get(position);

//        TODO : load ảnh từ server url
        holder.ibtnItem.setImageResource(meditateTopic.getImage());
        if (position == 0) {
            holder.ibtnItem.setBackgroundTintList(activeColorBtn);
            holder.txtItem.setTextColor(activeColorTxt);
        } else {
            holder.ibtnItem.setBackgroundTintList(inactiveColorBtn);
            holder.txtItem.setTextColor(inactiveColorTxt);
        }
        holder.txtItem.setText(meditateTopic.getName());

        holder.llItem.setOnClickListener(v -> {
            ColorStateList currentColor = holder.ibtnItem.getBackgroundTintList();
            if (!currentColor.equals(activeColorBtn)) {
                holder.ibtnItem.setBackgroundTintList(activeColorBtn);
                holder.txtItem.setTextColor(activeColorTxt);
            } else {
                holder.ibtnItem.setBackgroundTintList(inactiveColorBtn);
                holder.txtItem.setTextColor(inactiveColorTxt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meditateTopicList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup llItem;
        ImageButton ibtnItem;
        TextView txtItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            llItem = itemView.findViewById(R.id.llMeditateTopicItem);
            ibtnItem = itemView.findViewById(R.id.imageButtonMeditateTopicItem);
            txtItem = itemView.findViewById(R.id.textViewMeditateTopicNameItem);
        }
    }
}
