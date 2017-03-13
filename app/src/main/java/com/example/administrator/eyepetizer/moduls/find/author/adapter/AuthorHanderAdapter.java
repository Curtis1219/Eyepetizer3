package com.example.administrator.eyepetizer.moduls.find.author.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * Created by Administrator on 2017/3/10.
 */
public class AuthorHanderAdapter extends PagerAdapter{

    private List<ImageView> viewList;

    public AuthorHanderAdapter(List<ImageView> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
//        super.destroyItem(container, position, object);
    }
}
