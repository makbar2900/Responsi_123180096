package com.makbarrivaldo.responsi.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.makbarrivaldo.responsi.R;

import com.makbarrivaldo.responsi.view.fragment.KasusFragment;
import com.makbarrivaldo.responsi.view.fragment.RsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_navbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new KasusFragment());
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.im_kasus_covid:
                selectedFragment = new KasusFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.im_rs_rujukan:
                selectedFragment = new RsFragment();
                loadFragment(selectedFragment);
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainframe,selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}