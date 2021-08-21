package com.haui.phamdai.silentmoon.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.haui.phamdai.silentmoon.R;
import com.haui.phamdai.silentmoon.adapters.HomePagerAdapter;
import com.haui.phamdai.silentmoon.fragments.home.SleepFragment;
import com.haui.phamdai.silentmoon.utils.ColorUtil;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    ViewPager viewPagerHome;
    private static final String TEXT_ACTIVE_COLOR = "#8E97FD";
    private static final String TEXT_INACTIVE_COLOR = "#A0A3B1";
    private static final String SLEEP_TEXT_ACTIVE_COLOR = "#E6E7F2";
    private static final String SLEEP_TEXT_INACTIVE_COLOR = "#98A1BD";
    private MenuItem lastSelectedItem = null;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.navigation);
        viewPagerHome = findViewById(R.id.viewPagerHome);

//        khởi tạo
        navigation.setItemIconTintList(null);
        lastSelectedItem = navigation.getMenu().findItem(R.id.action_home);
        HomePagerAdapter adapter;
        manager = getSupportFragmentManager();

        Bundle bundle = getIntent().getBundleExtra("data");
        if (bundle == null) {
            adapter = new HomePagerAdapter(manager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, null);
            viewPagerHome.setAdapter(adapter);
        } else {
            adapter = new HomePagerAdapter(manager,
                    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, bundle);
            viewPagerHome.setAdapter(adapter);

            viewPagerHome.setCurrentItem(1, false);
            MenuItem currentItem = navigation.getMenu().findItem(R.id.action_sleep);
            currentItem.setChecked(true);
            changeColorForSelectedItem(lastSelectedItem, currentItem);
            lastSelectedItem = currentItem;
        }
        // disable user swipe between screens
//        viewPagerHome.setOnTouchListener((v, event) -> true);

//        sự kiện chọn của bottom navigation
        navigation.setOnItemSelectedListener(item -> {
//           dòng này sẽ gọi luôn sự kiện viewPagerHome.addOnPageChangeListener
            viewPagerHome.setCurrentItem(getPageIndexByMenuId(item.getItemId()), false);
            return true;
        });

//        đồng bộ sự kiện swipe của ViewPager với BottomNavigationView
        viewPagerHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MenuItem currentItem;
                switch (position) {
                    case 0:
                        currentItem = navigation.getMenu().findItem(R.id.action_home);
                        currentItem.setChecked(true);
                        changeColorForSelectedItem(lastSelectedItem, currentItem);
                        lastSelectedItem = currentItem;
                        break;
                    case 1:
                        currentItem = navigation.getMenu().findItem(R.id.action_sleep);
                        currentItem.setChecked(true);
                        changeColorForSelectedItem(lastSelectedItem, currentItem);
                        lastSelectedItem = currentItem;
                        break;
                    case 2:
                        currentItem = navigation.getMenu().findItem(R.id.action_meditate);
                        currentItem.setChecked(true);
                        changeColorForSelectedItem(lastSelectedItem, currentItem);
                        lastSelectedItem = currentItem;
                        break;
                    case 3:
                        currentItem = navigation.getMenu().findItem(R.id.action_music);
                        currentItem.setChecked(true);
                        changeColorForSelectedItem(lastSelectedItem, currentItem);
                        lastSelectedItem = currentItem;
                        break;
                    case 4:
                        currentItem = navigation.getMenu().findItem(R.id.action_group);
                        currentItem.setChecked(true);
                        changeColorForSelectedItem(lastSelectedItem, currentItem);
                        lastSelectedItem = currentItem;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void replace() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.sleepFragmentContainer, SleepFragment.class, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private int getPageIndexByMenuId(int menuId) {
        //list item
        Menu menu = navigation.getMenu();
        int position = 0;
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() == menuId) {
                position = i;
                break;
            }
        }
        return position;
    }

    private void changeColorForSelectedItem(MenuItem lastItem, MenuItem currentItem) {
        if (lastItem != null) {
            setDisabledForItem(lastItem);
            setEnabledForItem(currentItem);
        }
    }

    @SuppressLint("NonConstantResourceId")
    private void setEnabledForItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                // đổi icon cho item
                item.setIcon(R.drawable.bottom_icon_home_enabled);
                // đổi màu nền và màu chữ cho item
                setBackgroundNavColor();
                break;
            case R.id.action_sleep:
                item.setIcon(R.drawable.bottom_icon_sleep_enabled);
                setSleepBackgroundNavColor();
                break;
            case R.id.action_meditate:
                item.setIcon(R.drawable.bottom_icon_meditate_enabled);
                setBackgroundNavColor();
                break;
            case R.id.action_music:
                item.setIcon(R.drawable.bottom_icon_music_enabled);
                setBackgroundNavColor();
                break;
            case R.id.action_group:
                item.setIcon(R.drawable.bottom_icon_group_enabled);
                setBackgroundNavColor();
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    private void setDisabledForItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                item.setIcon(R.drawable.bottom_icon_home_disabled);
                break;
            case R.id.action_sleep:
                item.setIcon(R.drawable.bottom_icon_sleep_disabled);
                break;
            case R.id.action_meditate:
                item.setIcon(R.drawable.bottom_icon_meditate_disabled);
                break;
            case R.id.action_music:
                item.setIcon(R.drawable.bottom_icon_music_disabled);
                break;
            case R.id.action_group:
                item.setIcon(R.drawable.bottom_icon_group_disabled);
                break;
        }
    }

    private void setBackgroundNavColor() {
        navigation.setItemTextColor(ColorUtil.getItemTextColorList(
                TEXT_ACTIVE_COLOR,
                TEXT_INACTIVE_COLOR));
        navigation.setItemBackgroundResource(R.color.bot_nav_background_color);
    }

    private void setSleepBackgroundNavColor() {
        navigation.setItemTextColor(ColorUtil.getItemTextColorList(
                SLEEP_TEXT_ACTIVE_COLOR,
                SLEEP_TEXT_INACTIVE_COLOR));
        navigation.setItemBackgroundResource(R.color.sleep_bot_nav_background_color);
    }


}