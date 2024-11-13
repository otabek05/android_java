package com.daeryuk.fsapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Intents facilitate communication between different component as well as between different applications

        // Type of intents
        // 1- Explicit Intents  ===> used specific components within the application, by specifying component class name
        // 2- Implicit Intents

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecond();
            }
        });
        Toast.makeText(this, "onCreate method has been called", Toast.LENGTH_SHORT).show();

    }

    public void moveToSecond() {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart method has been called", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected  void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume method has been called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause method has been called", Toast.LENGTH_LONG).show();

    }

    @Override
    protected  void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop method has been called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart method has been called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void  onDestroy() {
        super.onDestroy();


        Toast.makeText(this, "onDestroy method has been called", Toast.LENGTH_SHORT).show();
    }
}