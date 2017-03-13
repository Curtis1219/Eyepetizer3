package com.example.administrator.eyepetizer.moduls.find;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.find.adapter.FindAdapter;
import com.example.administrator.eyepetizer.moduls.find.author.AuthorFragment;
import com.example.administrator.eyepetizer.moduls.find.classification.FenLeiFragment;
import com.example.administrator.eyepetizer.moduls.find.popular.PopularFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {


    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_author, container, false);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_discover_tabLayout);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_discover_viewPager);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabLayout,35,35);
            }
        });

        //添加发现中的三个小模块  Fragment集合
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AuthorFragment());
        fragments.add(new FenLeiFragment());
        fragments.add(new PopularFragment());

        List<String> titles = new ArrayList<>();
        titles.add("热门");
        titles.add("分类");
        titles.add("作者");

        FindAdapter adapter = new FindAdapter(getChildFragmentManager(),fragments,titles);

        viewPager.setAdapter(adapter);

        //tablayout 关联  ViewPager
        tabLayout.setupWithViewPager(viewPager);


        return view;

    }

    public void setIndicator (TabLayout tabs,int leftDip,int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
