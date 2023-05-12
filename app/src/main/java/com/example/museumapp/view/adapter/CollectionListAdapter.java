package com.example.museumapp.view.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumapp.R;
import com.example.museumapp.bean.Collection;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

import java.util.List;

public class CollectionListAdapter extends RecyclerView.Adapter<CollectionListAdapter.MyViewHolder>{
    private List<Collection> list;
    private Context context;
    private RecyclerView recyclerView;
    private View inflater;

    public CollectionListAdapter(List<Collection> list, Context context, RecyclerView recyclerView) {
        this.list = list;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.collection_icon.setImageResource(list.get(position).getIcon());
        holder.collection_name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        QMUILinearLayout itemLayout;
        ImageView collection_icon;
        TextView collection_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view){
            itemLayout = (QMUILinearLayout) view.findViewById(R.id.item_collection);
            collection_icon = (ImageView) view.findViewById(R.id.collection_icon);
            collection_name = (TextView) view.findViewById(R.id.collection_name);

            itemLayout.setRadius(20);
        }
    }
}
