package com.haui.phamdai.silentmoon.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haui.phamdai.silentmoon.views.CourseDetailsActivity;
import com.haui.phamdai.silentmoon.models.Category;
import com.haui.phamdai.silentmoon.adapters.CategoryAdapter;
import com.haui.phamdai.silentmoon.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCategory_Home);
        Context context = recyclerView.getContext();
        CategoryAdapter adapter = new CategoryAdapter(getCategorys());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        view.findViewById(R.id.buttonBasicStart_Home).setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), CourseDetailsActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private List<Category> getCategorys() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.focus_category, "Focus", "3–10 MIN"));
        categoryList.add(new Category(R.drawable.happiness_category, "Happiness", "3–10 MIN"));
        categoryList.add(new Category(R.drawable.focus_category, "Category 1", "5–8 MIN"));
        categoryList.add(new Category(R.drawable.focus_category, "Category 2", "6–8 MIN"));
        categoryList.add(new Category(R.drawable.focus_category, "Category 3", "4–9 MIN"));
        return categoryList;
    }
}