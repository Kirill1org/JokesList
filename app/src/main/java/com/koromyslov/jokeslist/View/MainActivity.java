package com.koromyslov.jokeslist.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.koromyslov.jokeslist.R;
import com.koromyslov.jokeslist.View.JokesFragment;
import com.koromyslov.jokeslist.View.WebFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment jokesFragment;
    private Fragment webFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.bn_jokes:
                fragment = JokesFragment.newInstance();
                break;
            case R.id.bn_web:
                fragment = WebFragment.newInstance();
                break;
        }
        if (fragment == null) {
            return false;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        return true;
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (jokesFragment != null && jokesFragment.isAdded()) {
            Log.e("Jokes Fragment", "SAVE JOKES FRAGMENT");
            getSupportFragmentManager().putFragment(outState, "jokesFragment", jokesFragment);
        }
        if (webFragment != null && webFragment.isAdded()) {
            Log.e("Web Fragment", "SAVE WEB FRAGMENT");
            getSupportFragmentManager().putFragment(outState, "webFragment", webFragment);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.nav_view);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            jokesFragment = JokesFragment.newInstance();
            webFragment = new WebFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, jokesFragment);
            fragmentTransaction.commit();
        }
        if (savedInstanceState != null) {
            webFragment = getSupportFragmentManager().getFragment(savedInstanceState, "webFragment");
            jokesFragment = getSupportFragmentManager().getFragment(savedInstanceState, "jokesFragment");
        }
    }
}
