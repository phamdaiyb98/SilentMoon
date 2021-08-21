package com.haui.phamdai.silentmoon.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;

import com.haui.phamdai.silentmoon.R;

public class ColorUtil {
    public static ColorStateList getColor(Context context, int colorResId) {
        return ColorStateList.valueOf(context.getResources().getColor(colorResId));
    }

    public static ColorStateList getItemTextColorList(String activeColor, String inactiveColor) {
        int color = Color.parseColor(activeColor);
        int navDefaultTextColor = Color.parseColor(inactiveColor);
        int[][] states = new int[][]{
                new int[]{android.R.attr.state_selected}, // selected
                new int[]{} // default
        };
        int[] colors = new int[]{
                color,
                navDefaultTextColor
        };
        return new ColorStateList(states, colors);
    }

}
