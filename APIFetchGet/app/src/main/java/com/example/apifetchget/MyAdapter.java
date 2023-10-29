package com.example.apifetchget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Post> mDataList; // List of data to be displayed
    private LayoutInflater mInflater; // Inflater to inflate views

    // Constructor to initialize the adapter
    public MyAdapter(Context context, List<Post> dataList) {
        this.mInflater = LayoutInflater.from(context);
        this.mDataList = dataList;
    }

    // Method to create a ViewHolder for each item in the RecyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    // Method to bind data to ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Post data = mDataList.get(position);
        holder.bindData(data.getId(), data.getName(), data.getTitle(), data.getDescription());
    }

    // Method to get the total number of items in the RecyclerView
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    // ViewHolder class to hold and manage individual item views
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView1;// TextView to display data
        private TextView mTextView2;
        private TextView mTextView3;
        private TextView mTextView4;

        // Constructor to initialize the ViewHolder
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.t1);
            mTextView2 = itemView.findViewById(R.id.t2);
            mTextView3 = itemView.findViewById(R.id.t3);
            mTextView4 = itemView.findViewById(R.id.t4);
        }

        // Method to bind data to the item view
        public void bindData(String data1,String data2,String data3,String data4) {
            mTextView1.setText(data1);
            mTextView2.setText(data2);
            mTextView3.setText(data3);
            mTextView4.setText(data4);
        }
    }
}
