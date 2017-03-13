package com.example.administrator.eyepetizer.moduls.mine;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.eyepetizer.R;


public class HuancunActivty extends AppCompatActivity {

    private ImageView iv;
    private RadioGroup rg;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_huancun_activty);

        rg = (RadioGroup) findViewById(R.id.rg_id);
        tv = (TextView) findViewById(R.id.tv_md_id);
        iv = (ImageView) findViewById(R.id.iv_md_back03);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.tv_rg_01:
                        tv.setText("你缓存的视频可以在这里找到");
                        break;
                    case R.id.tv_rg_02:
                        tv.setText("自动缓存的视频可以在这里找到");
                        break;
                }
            }
        });


    }
}
