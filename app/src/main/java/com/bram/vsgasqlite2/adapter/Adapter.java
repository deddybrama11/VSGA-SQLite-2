package com.bram.vsgasqlite2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bram.vsgasqlite2.MainActivity;
import com.bram.vsgasqlite2.R;
import com.bram.vsgasqlite2.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    List<Data> items;

    public Adapter(MainActivity activity, List<Data> itemList) {
        this.activity = activity;
        this.items = itemList;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null){
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null){
            view = inflater.inflate(R.layout.list_row,null);
        }

        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView address = view.findViewById(R.id.address);

        Data data = items.get(i);
        id.setText(data.getId());
        name.setText(data.getName());
        address.setText(data.getAddress());
        return null;
    }
}
