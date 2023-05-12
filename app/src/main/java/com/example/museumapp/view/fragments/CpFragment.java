package com.example.museumapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.museumapp.R;
import com.example.museumapp.bean.Collection;
import com.example.museumapp.bean.TestData;
import com.example.museumapp.view.adapter.CollectionListAdapter;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CpFragment extends Fragment {
    private QMUIContinuousNestedBottomRecyclerView recyclerView;
    private List<Collection> collectionList;
    private CollectionListAdapter collectionListAdapter;
    private Context context;

    public CpFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cp, container, false);
        initList();
        initViews(view);
        return view;
    }

    private void initList() {
        collectionList = new ArrayList<>();
        collectionList = TestData.getCollections();
    }

    /**
     * 初始化界面控件
     */
    private void initViews(View view){
        recyclerView = (QMUIContinuousNestedBottomRecyclerView) view.findViewById(R.id.collection_rv);
        initRecyclerViewAdapter();
    }

    /**
     * 初始化藏品列表适配器
     */
    private void initRecyclerViewAdapter() {
        collectionListAdapter = new CollectionListAdapter(collectionList, context, recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(collectionListAdapter);
    }
}
