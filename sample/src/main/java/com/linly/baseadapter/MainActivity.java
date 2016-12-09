package com.linly.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.linly.baseadapterlibrary.baselistview.CommAdapter;

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
        CommAdapter commAdapter = new CommAdapter(this,R.layout.item_listview_main,R.id.tv_item,list);
        mListView.setAdapter(commAdapter);
    }
}
