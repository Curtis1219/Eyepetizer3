package com.example.administrator.eyepetizer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.eyepetizer.moduls.attention.AttentionFragment;
import com.example.administrator.eyepetizer.moduls.featured.FeaturedFragment;
import com.example.administrator.eyepetizer.moduls.find.FindFragment;
import com.example.administrator.eyepetizer.moduls.mine.MineFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup radioGroup;
    private FragmentManager manager;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //获取fragment管理器
        manager = getSupportFragmentManager();
        initFragment();
        initView();

    }

    private void initView() {

        radioGroup = (RadioGroup) findViewById(R.id.activity_main_radioGroup_bottom);
        radioGroup.setOnCheckedChangeListener(this);
        //设置第一个默认选中
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);

    }

    private void initFragment() {
        fragments = new Fragment[4];
        //发现

        FeaturedFragment featuredFragment = new FeaturedFragment();
        fragments[0] = featuredFragment;

        FindFragment findFragment = new FindFragment();
        fragments[1] = findFragment;

        AttentionFragment attentionFragment = new AttentionFragment();
        fragments[2] = attentionFragment;

        MineFragment mineFragment = new MineFragment();
        fragments[3] = mineFragment;


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        //导航实现fragment切换
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.activity_main_bottom_discover:
                transaction.replace(R.id.activity_main_container, fragments[0]);
                break;
            case R.id.activity_main_bottom_subscribe:
                transaction.replace(R.id.activity_main_container, fragments[1]);
                break;
            case R.id.activity_main_bottom_download:
                transaction.replace(R.id.activity_main_container, fragments[2]);
                break;
            case R.id.activity_main_bottom_personal:
                transaction.replace(R.id.activity_main_container, fragments[3]);
                break;
        }
        transaction.commit();

    }
}
