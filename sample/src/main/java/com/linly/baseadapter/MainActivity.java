package com.linly.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.linly.baseadapterlibrary.baselistview.CommAdapter;
import com.linly.baseadapterlibrary.baselistview.ViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList list = new ArrayList();
        for (int i = 0; i < 40; i++) {
            list.add(i+"");
        }
        mListView = (ListView) findViewById(R.id.lv_main);
        CommAdapter commAdapter = new CommAdapter<String >(this,R.layout.item_listview_main,R.id.tv_item,list){

            @Override
            public void convert(ViewHolder holder, String data) {
                TextView tv = holder.getView(R.id.tv_item);
                Button okButton = holder.getView(R.id.btn_ok);
                tv.setText(data);
                okButton.setText(data+"确定");
            }
        };
        mListView.setAdapter(commAdapter);
    }
}
