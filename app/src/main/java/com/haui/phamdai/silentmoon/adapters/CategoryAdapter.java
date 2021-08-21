package com.haui.phamdai.silentmoon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categoryList.get(position);

        holder.iv.setImageResource(category.getImage());
        holder.txtName.setText(category.getName());
        holder.txtTime.append(" ");
        holder.txtTime.append(category.getTime());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView txtName;
        TextView txtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.imageViewCategoryItem);
            txtName = itemView.findViewById(R.id.textViewItemCategoryName);
            txtTime = itemView.findViewById(R.id.textViewItemCategoryTime);
        }
    }
}
