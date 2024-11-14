package com.daeryuk.fsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daeryuk.fsapp.models.Country;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private List<Country> items;

    public MyCustomAdapter(Context context, List<Country> items) {
        this.context = context;
        this.items = items;
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
        ViewHolder holder;

        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.my_list_item, viewGroup, false);
            holder = new ViewHolder();
            holder.name = view.findViewById(R.id.text1);
            holder.currency = view.findViewById(R.id.text2);

            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();

        }
        holder.name.setText(items.get(i).getName());
        holder.currency.setText(items.get(i).getCurrency());
        return view;
    }

    static class ViewHolder {
        TextView name;
        TextView currency;

    }


}
