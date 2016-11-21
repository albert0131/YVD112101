package com.example.user.yvd112101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String fruits[] = {"蘋果", "西瓜", "楊桃", "鳳梨"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(MainActivity.this, fruits);
        lv.setAdapter(adapter);
    }


}
