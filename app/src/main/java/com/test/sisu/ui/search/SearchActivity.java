package com.test.sisu.ui.search;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.test.sisu.R;
import com.test.sisu.models.CourseResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Indigo on 9/11/16.
 */
public class SearchActivity extends AppCompatActivity {

    public static final String BUNDLE_COURSE = "BUNDLE_COURSE";
    public static final String BUNDLE_ALL_COURSES = "BUNDLE_ALL_COURSES";

    @BindView(R.id.search_recyclerview)
    RecyclerView recyclerView;

    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        setupActionBar();
        setupRecyclerView();
    }

    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupRecyclerView() {
        adapter = new SearchAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        String value;
        if (extras != null) {
            value = extras.getString(BUNDLE_ALL_COURSES);

            CourseResponse response = new Gson().fromJson(value, CourseResponse.class);

            adapter.setData(response);
        }
    }
}
