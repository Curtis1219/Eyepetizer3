package com.example.administrator.eyepetizer.moduls.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.eyepetizer.R;


/**
 * Created by jp on 2017/3/5.
 */

public class MineFragment extends Fragment {
    private Button btn_01, btn_02, button;
    //控件
    private ListView lv;
    private String[] item = {"我的消息", "我的关注", "我的缓存", "意见反馈", "我要投稿"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wode, container, false);

        lv = (ListView) view.findViewById(R.id.wo_de_lv);
        lv.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.wd_lv_item, item));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent();
                switch (i) {
                    case 0:

                        intent.setClass(getContext(), XiaoxiActivity.class);
                        break;
                    case 1:
                        intent.setClass(getContext(), GuanzhuxiActivity.class);
                        break;
                    case 2:

                        intent.setClass(getContext(),HuancunActivty.class);
                        break;
                    case 3:
                        intent.setClass(getContext(), YijianActivty.class);
                        break;
                    case 4:
                        intent.setClass(getContext(), TouGaoActivty.class);
                        break;
                }
                startActivity(intent);
            }
        });


        btn_02 = (Button) view.findViewById(R.id.button_02);
        btn_01 = (Button) view.findViewById(R.id.button_01);
        button = (Button) view.findViewById(R.id.button_more);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "设置功能未开启", Toast.LENGTH_SHORT).show();
            }
        });
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), DengluActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

}
