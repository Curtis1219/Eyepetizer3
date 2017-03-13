package com.example.administrator.eyepetizer.moduls.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.example.administrator.eyepetizer.R;


public class DengluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_denglu);


    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.weibo:

                break;
            case R.id.weixin:

                break;
            case R.id.qq:


                break;

        }


    }
}
