package com.daeryuk.fsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daeryuk.fsapp.adapters.MyRecycleViewAdapter;
import com.daeryuk.fsapp.adapters.ProductRecycleAdapter;
import com.daeryuk.fsapp.models.Country;
import com.daeryuk.fsapp.models.Product;
import com.daeryuk.fsapp.repo.ItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements ItemClickListener {

    List<Country> countryList = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        products.add(new Product("Olcha", R.drawable.ass, 10.99));
        products.add(new Product("Olxo'ri", R.drawable.box, 10.99));
        products.add(new Product("Boxing is very goog", R.drawable.toss, 10.33));
        products.add(new Product("Olmacha olmachag", R.drawable.brain, 10.99));

       ProductRecycleAdapter adapter = new ProductRecycleAdapter(products);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Correct variable name (changed from 'ItemId' to 'itemId')


        if (itemId == R.id.action_search) {
            // Handle search action (navigate to a new activity or show search UI)
            Intent searchIntent = new Intent(this, Second.class); // Second is your search activity
            startActivity(searchIntent);
        } else if (itemId == R.id.action_home) {
            // Handle home action (navigate to the main/home activity)
            Intent homeIntent = new Intent(this, ScrollingActivity.class); // MainActivity is your home activity
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clears the activity stack
            startActivity(homeIntent);
        }else {
            return super.onOptionsItemSelected(item); // Default handling for unrecognized items
        }

        return true; // Indicate that the menu item was handled
    }




    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "You choose" + countryList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}