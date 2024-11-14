package com.daeryuk.fsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daeryuk.fsapp.R;
import com.daeryuk.fsapp.models.Country;
import com.daeryuk.fsapp.repo.ItemClickListener;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    private List<Country>  countries;
    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener listener) {
        this.clickListener = listener;
    }

    public MyRecycleViewAdapter (List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.name.setText(country.getName());
        holder.currency.setText(country.getCurrency());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView currency;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.country_name);
            currency = itemView.findViewById(R.id.country_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(clickListener != null) {
                clickListener.onClick(v, getAbsoluteAdapterPosition());
            }
        }
    }
}
