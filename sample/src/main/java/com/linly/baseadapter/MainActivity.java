package com.linly.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.linly.baseadapterlibrary.baselistview.CommAdapter;
import com.linly.baseadapterlibrary.baselistview.User;
import com.linly.baseadapterlibrary.baselistview.ViewHolder;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    CommAdapter commAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<User>();
        for (int i = 0; i < 40; i++) {

            User u = new User();
            u.setName(""+i);
            list.add(u);
        }

        mListView = (ListView) findViewById(R.id.lv_main);
        commAdapter = new CommAdapter<User>(this, R.layout.item_listview_main, R.id.tv_item, list) {

            @Override
            public void convert(final ViewHolder holder, User data) {
//                holder.setOnClickListener(R.id.btn_ok, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        chageStatus(holder.getItemPosition());
//                    }
//                });
                final TextView tv = holder.getView(R.id.tv_item);
                tv.setText(data.getName());

            }
        };

        mListView.setAdapter(commAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,list.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    void chageStatus(int position) {
        User u = list.get(position);
        u.setName("hh");
        commAdapter.notifyDataSetChanged();
    }

}
