package com.example.museumapp.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.OnNewIntentProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumapp.R;;
import com.example.museumapp.bean.New;
import com.example.museumapp.view.Iterface.OnNewItemClickListener;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

import java.util.List;

public class NewListAdapter extends RecyclerView.Adapter<NewListAdapter.MyViewHolder> implements View.OnClickListener{
    private List<New> list;
    private Context context;
    private RecyclerView recyclerView;
    private OnNewItemClickListener onNewItemClickListener;
    private View inflater;

    public void setOnNewItemClickListener(OnNewItemClickListener onNewItemClickListener){
        this.onNewItemClickListener = onNewItemClickListener;
    }

    public NewListAdapter(List<New> list, Context context, RecyclerView recyclerView) {
        this.list = list;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public NewListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item_new, parent, false);
        //设置监听
        inflater.setOnClickListener(this);
        NewListAdapter.MyViewHolder myViewHolder = new NewListAdapter.MyViewHolder(inflater);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewListAdapter.MyViewHolder holder, int position) {
        holder.new_icon.setImageResource(list.get(position).getIcon());
        holder.new_title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        int position = recyclerView.getChildAdapterPosition(view);
        if(onNewItemClickListener != null){
            onNewItemClickListener.onItemClick(recyclerView, view, position, list.get(position));
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        QMUILinearLayout itemLayout;
        ImageView new_icon;
        TextView new_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view){
            itemLayout = (QMUILinearLayout) view.findViewById(R.id.item_new);
            new_icon = (ImageView) view.findViewById(R.id.new_icon);
            new_title = (TextView) view.findViewById(R.id.new_title);

            itemLayout.setRadius(20);
        }
    }
}
