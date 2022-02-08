package com.example.samples.firebaseobjects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samples.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleRecyclerViewAdapter.SampleHolder> {

    private final OnStateClickListener onClickListener;
    private final ArrayList<Object> objects;
    private final Context context;
    private Map<String, Bitmap> savedIcons = new HashMap<>();

    public SampleRecyclerViewAdapter(Context context, ArrayList<Object> objects, OnStateClickListener onClickListener) {
        this.context = context;
        this.objects = objects;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public SampleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sample_item_list, parent, false);

        SampleHolder holder = new SampleHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SampleHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(position);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onClickListener.onStateClick(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return objects.size();
    }

    public interface OnStateClickListener{
        void onStateClick(int itemPosition);
    }

    class SampleHolder extends RecyclerView.ViewHolder{

        private TextView sampleTextView;
        Object o;

        public SampleHolder(@NonNull View itemView) {
            super(itemView);
            sampleTextView = itemView.findViewById(R.id.sample_text_view);
        }

        public void bind(int listIndex){
            o = objects.get(listIndex);
            sampleTextView.setText(o.toString());
        }
    }
}
