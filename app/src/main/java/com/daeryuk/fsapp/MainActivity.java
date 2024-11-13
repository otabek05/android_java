package com.daeryuk.fsapp;

import android.os.Bundle;

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

        Toast.makeText(this, "onCreate method has been called", Toast.LENGTH_SHORT).show();

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