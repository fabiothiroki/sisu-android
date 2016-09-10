package com.test.sisu.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.sisu.R;
import com.test.sisu.services.CourseService;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPresenter();;

        mainPresenter.loadCourses();
    }

    private void setupPresenter() {

        this.mainPresenter = new MainPresenter(this, new CourseService());

    }
}
