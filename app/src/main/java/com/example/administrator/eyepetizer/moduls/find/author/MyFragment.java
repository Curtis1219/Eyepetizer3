package com.example.administrator.eyepetizer.moduls.find.author;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.eyepetizer.R;

/**
 * Created by Administrator on 2017/3/11.
 */

public class MyFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        ImageView imageView = new ImageView(getActivity());

        int tab = getArguments().getInt("tab");

        switch (tab) {
            case 0:
                imageView.setImageResource(R.drawable.ic_notification);
                break;

            case 1:
                imageView.setImageResource(R.drawable.ic_tab_strip_icon_feed);
                break;

            case 2:
                imageView.setImageResource(R.drawable.ic_tab_strip_icon_category);
                break;
        }
        return imageView;
    }
}
