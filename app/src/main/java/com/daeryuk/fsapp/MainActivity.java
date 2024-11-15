package com.daeryuk.fsapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.daeryuk.fsapp.adapters.MyViewPageAdapter;
import com.daeryuk.fsapp.repo.ItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity  implements ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs =  findViewById(R.id.tabs);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        MyViewPageAdapter adapter = new MyViewPageAdapter(getSupportFragmentManager(), getLifecycle());

        adapter.addFragment(new Frangment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Tab3());

        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Fragment " + (position +1));
            }
        }).attach();

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
            Intent searchIntent = new Intent(this, Second.class); // Second is your search activity
            startActivity(searchIntent);
        } else if (itemId == R.id.action_home) {
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
      //  Toast.makeText(this, "You choose" + countryList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}