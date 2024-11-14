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
import com.daeryuk.fsapp.models.Country;
import com.daeryuk.fsapp.repo.ItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements ItemClickListener {

    List<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MyRecycleViewAdapter adapter;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        countryList.add(new Country("United States", "USD"));
        countryList.add(new Country("Canada", "CAD"));
        countryList.add(new Country("Japan", "JPY"));
        countryList.add(new Country("Germany", "EUR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));
        countryList.add(new Country("India", "INR"));


        adapter = new MyRecycleViewAdapter(countryList);
       adapter.setClickListener(this);
       recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(adapter);



        /*
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b ) {
                    // Code to execute
                    Toast.makeText(MainActivity.this, "Checkbox is chekcked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        */


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
    // Intents facilitate communication between different component as well as between different applications

    // Type of intents
    // 1- Explicit Intents  ===> used specific components within the application, by specifying component class name
    // 2- Implicit Intents  ===> used for extenal services in the phone such as browser or camera

   // Explicit Intents

    public void moveToSecond() {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    // Implicit Intents

    public void openNewPage() {
        Uri webpage = Uri.parse("https://daeryuk.org");

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void openCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "You choose" + countryList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}