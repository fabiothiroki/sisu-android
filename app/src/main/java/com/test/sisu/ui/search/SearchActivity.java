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
public class SearchActivity extends AppCompatActivity implements SearchContract {

    public static final String BUNDLE_COURSE = "BUNDLE_COURSE";
    public static final String BUNDLE_ALL_COURSES = "BUNDLE_ALL_COURSES";

    @BindView(R.id.search_recyclerview)
    RecyclerView recyclerView;

    private SearchAdapter adapter;

    private SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        setupActionBar();
        setupRecyclerView();
        setupPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        searchPresenter.onDestroy();
    }

    private void setupPresenter() {

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString(BUNDLE_ALL_COURSES);

            CourseResponse response = new Gson().fromJson(value, CourseResponse.class);

            String searchString = extras.getString(BUNDLE_COURSE);

            searchPresenter = new SearchPresenter(this, response);

            searchPresenter.onSearchStringChanged(searchString);
            getSupportActionBar().setTitle(searchString);
        }

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
    }

    @Override
    public void setNewDataSource(CourseResponse newDataSource) {
        adapter.setData(newDataSource);
    }
}
