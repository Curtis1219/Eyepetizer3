package com.example.administrator.eyepetizer.moduls.mine;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.eyepetizer.R;

import java.util.ArrayList;
import java.util.List;

public class GuanzhuxiActivity extends AppCompatActivity {
    private ViewPager vp;
    private MyAdapter adapter;
    private TabLayout tab;
    private String []title={"作者订阅列表","分类订阅列表"};
    private List<Fragment>list;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guanzhuxi);
        vp= (ViewPager) findViewById(R.id.viewpager_md);
        tab = (TabLayout) findViewById(R.id.tab_lyout_my);
        iv = (ImageView) findViewById(R.id.iv_md_back02);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initData();

        tab.setupWithViewPager(vp);
        adapter=new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);



    }

    private void initData() {

        list=new ArrayList<>();
        list.add(new ZzdyFragment());
        list.add(new FldyFragment());

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
