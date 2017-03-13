package com.example.administrator.eyepetizer.moduls.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.eyepetizer.R;


public class TouGaoActivty extends AppCompatActivity {

    private EditText ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tou_gao_activty);
        ed1 = (EditText) findViewById(R.id.ed_yj_01);
        ed2 = (EditText) findViewById(R.id.ed_yj_02);
        ed3 = (EditText) findViewById(R.id.ed_yj_03);


    }
    public void click(View view) {
        switch (view.getId()){
            case R.id.iv_md_back05:
                finish();
                break;
            case R.id.tv_tg:
                if(TextUtils.isEmpty(ed2.getText())||TextUtils.isEmpty(ed3.getText())){
                    Toast.makeText(this,"输入的内容不能为空!!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"投稿成功!!!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
