package com.test.sisu.ui.search;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.test.sisu.R;

import butterknife.ButterKnife;

/**
 * Created by Indigo on 9/11/16.
 */
public class SearchActivity extends AppCompatActivity {

    public static final String BUNDLE_COURSE = "BUNDLE_COURSE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        setupActionBar();
    }

    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
}
