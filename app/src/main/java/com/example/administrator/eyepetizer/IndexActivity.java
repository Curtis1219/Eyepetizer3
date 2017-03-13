package com.example.administrator.eyepetizer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IndexActivity extends AppCompatActivity {

    //控件
    private ImageView imageView;

    //数据源


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:

                    Intent intent = new Intent();
                    intent.setClass(IndexActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);

        imageView= (ImageView) findViewById(R.id.image_index);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.enlarge);
        //动画执行完后停留在此动画的最后一帧
        animation.setFillAfter(true);
        animation.setDuration(5000);
        //执行动画
        imageView.startAnimation(animation);

        Message message = Message.obtain();
        message.what = 1;
        handler.sendMessageDelayed(message, 1000);

    }

}
