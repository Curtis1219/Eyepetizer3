package com.example.administrator.eyepetizer.moduls.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.eyepetizer.R;


public class YijianActivty extends AppCompatActivity {

    private EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yijian_activty);
        ed1 = (EditText) findViewById(R.id.ed_01);
        ed2 = (EditText) findViewById(R.id.ed_02);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.iv_md_back04:
                finish();
                break;
            case R.id.tv_yj:
                if(TextUtils.isEmpty(ed1.getText())||TextUtils.isEmpty(ed2.getText())){
                    Toast.makeText(this,"输入的内容不能为空!!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"提交成功!!!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
