package com.daeryuk.fsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daeryuk.fsapp.models.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn2 = findViewById(R.id.second_btn);

        // AdapterView
        list = findViewById(R.id.list);

        List <Country>  countries = new ArrayList<>(
                Arrays.asList(
                        new Country("USA", "USD"),
                        new Country("UK", "GBP"),
                        new Country("KAZAKHISTAN", "KZT")
                )
        );


    }


    public void moveToFirst() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}