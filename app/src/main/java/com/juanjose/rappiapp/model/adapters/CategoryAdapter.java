package com.juanjose.rappiapp.model.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.juanjose.rappiapp.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by juanjosemolina on 27/02/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder>{

    private List<String> categories;
    private int resource;
    private Activity activity;

    public CategoryAdapter(List<String> categories, int resource, Activity activity) {
        this.categories = categories;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CategoryHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public CategoryHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.categoryNameCard);
        }
    }
}
