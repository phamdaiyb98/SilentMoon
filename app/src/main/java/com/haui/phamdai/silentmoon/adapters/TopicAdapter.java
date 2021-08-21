package com.haui.phamdai.silentmoon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.Topic;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    private final List<Topic> topicList;

    public TopicAdapter(List<Topic> topicList) {
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.ViewHolder holder, int position) {
        Topic topic = topicList.get(position);

        // setImageURI if get image from server
        holder.ivTopic.setImageResource(topic.getBackgroundImg());
        holder.txtTopicName.setText(topic.getTopic());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTopic;
        TextView txtTopicName;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTopic = itemView.findViewById(R.id.imageViewTopic);
            txtTopicName = itemView.findViewById(R.id.textViewTopicName);
        }

    }
}
