package com.test.sisu.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.sisu.R;
import com.test.sisu.models.Course;
import com.test.sisu.models.CourseResponse;

/**
 * Created by Indigo on 9/11/16.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private CourseResponse courseResponse;

    public void setData(final CourseResponse courseResponse) {
        this.courseResponse = courseResponse;
        notifyDataSetChanged();
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_search_cell, parent, false);

        SearchViewHolder vh = new SearchViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        Course course = courseResponse.courses.get(position);
        holder.courseName.setText(course.name);
        holder.courseType.setText(course.degree);

    }

    @Override
    public int getItemCount() {
        return courseResponse.courses.size();
    }
}
