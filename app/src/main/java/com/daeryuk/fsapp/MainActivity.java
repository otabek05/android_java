package com.daeryuk.fsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box = findViewById(R.id.check);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b ) {
                    // Code to execute
                    Toast.makeText(MainActivity.this, "Checkbox is chekcked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int ItemId = item.getItemId();
        if (ItemId == R.id.action_search) {
            moveToSecond();
        }else  {
            Toast.makeText(this, "You selected Other menu", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    // Intents facilitate communication between different component as well as between different applications

    // Type of intents
    // 1- Explicit Intents  ===> used specific components within the application, by specifying component class name
    // 2- Implicit Intents  ===> used for extenal services in the phone such as browser or camera

   // Explicit Intents

    public void moveToSecond() {
        Intent intent = new Intent(this, Second.class);

        intent.putExtra("username", "otabek");
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