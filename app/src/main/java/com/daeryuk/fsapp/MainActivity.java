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


public class MainActivity extends AppCompatActivity {
    Button btn;
    DatePicker date;
    TextView three;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView =  findViewById(R.id.gridView);
        btn = findViewById(R.id.button);
        date = findViewById(R.id.date);
        three =  findViewById(R.id.three);
        progressBar = findViewById(R.id.progressBar);

        String[] items = {"Item1", "Item2", "Item3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        gridView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int day = date.getDayOfMonth();
               int month = date.getMonth();
               int year = date.getYear();
               progressBar.setVisibility(View.VISIBLE);

               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       String dateString = String.format("%02d-%02d-%d", day, month+1, year);
                       three.setText(dateString);
                       progressBar.setVisibility(View.GONE);
                   }
               }, 2000);

            }
        });



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



}