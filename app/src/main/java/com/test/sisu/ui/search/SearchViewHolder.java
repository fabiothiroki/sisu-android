package com.test.sisu.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.sisu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Indigo on 9/11/16.
 */
public class SearchViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.course_name)
    TextView courseName;

    @BindView(R.id.course_type)
    TextView courseType;

    public SearchViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

}
