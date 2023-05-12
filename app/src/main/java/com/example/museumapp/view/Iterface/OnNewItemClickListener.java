package com.example.museumapp.view.Iterface;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.museumapp.bean.New;

public interface OnNewItemClickListener {

    /**
     *
     * @param parent
     * @param view
     * @param position
     * @param newItem
     */
    void onItemClick(RecyclerView parent, View view, int position, New newItem);
}
