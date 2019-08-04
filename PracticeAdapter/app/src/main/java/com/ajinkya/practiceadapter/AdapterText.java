package com.ajinkya.practiceadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterText extends BaseAdapter {

    private String Arr[];
    private Context mContext;


    public AdapterText(String[] arr, Context mContext) {
        Arr = arr;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return Arr.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;

        textView=new TextView(mContext);
        textView.setLayoutParams(new AbsListView.LayoutParams(200,200));
        textView.setPadding(20,20,20,20);

        textView.setText(Arr[position]);


        return textView;
    }
}
