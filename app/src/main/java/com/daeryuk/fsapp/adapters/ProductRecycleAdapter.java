package com.daeryuk.fsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daeryuk.fsapp.R;
import com.daeryuk.fsapp.models.Product;

import java.util.List;

public class ProductRecycleAdapter extends RecyclerView.Adapter<ProductRecycleAdapter.ProductHolder> {
    List<Product> lists;

    public ProductRecycleAdapter(List<Product> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false );
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int position) {
        Product product = lists.get(position);

        String price = String.format("%.2f $", product.getPrice());
        productHolder.img.setImageResource(product.getImage());
        productHolder.name.setText(product.getProductName());
        productHolder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    public static class ProductHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
