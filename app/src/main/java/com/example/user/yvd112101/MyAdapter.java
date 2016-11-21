package com.example.user.yvd112101;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 2016/11/21.
 *  new class MyAdapter &繼承 BaseAdapter
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    String[] data;
    boolean[] chks;             // for 紀錄checkbox是否被打勾

    public MyAdapter(Context context, String[] d) {

        this.context = context;
        this.data = d;
        chks = new boolean[d.length];
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Log.d("LV", "getView, position:" + position + ", content:" + data[position]);
        ViewHolder holder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.myitem, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView);
            holder.btn = (Button) convertView.findViewById(R.id.button);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(data[position]);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data[position], Toast.LENGTH_SHORT).show();
            }
        });


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chks[position] = isChecked;
                Log.d("LV", "chk position:" + position);
            }
        });
        holder.checkBox.setChecked(chks[position]);
        return convertView;
    }

    static class ViewHolder
    {
        TextView tv;
        Button btn;
        CheckBox checkBox;
    }
}
