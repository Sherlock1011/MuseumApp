package com.example.museumapp.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumapp.R;
import com.example.museumapp.bean.Collection;
import com.example.museumapp.bean.New;
import com.example.museumapp.bean.TestData;
import com.example.museumapp.view.Iterface.OnNewItemClickListener;
import com.example.museumapp.view.MainPageActivity;
import com.example.museumapp.view.NewsInfoActivity;
import com.example.museumapp.view.adapter.CollectionListAdapter;
import com.example.museumapp.view.adapter.NewListAdapter;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private QMUIContinuousNestedBottomRecyclerView recyclerView;
    private List<New> newsList;
    private NewListAdapter newListAdapter;
    private Context context;

    public NewsFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initData();
        initViews(view);
        return view;
    }

    /**
     * 初始化新闻数据
     */
    private void initData() {
        newsList = new ArrayList<>();
        newsList = TestData.getNews();
    }

    /**
     * 初始化界面控件
     * @param view
     */
    private void initViews(View view){
        recyclerView = (QMUIContinuousNestedBottomRecyclerView) view.findViewById(R.id.new_rv);
        initRecyclerViewAdapter();
    }

    /**
     * 初始化新闻列表适配器
     */
    private void initRecyclerViewAdapter() {
        newListAdapter = new NewListAdapter(newsList, context, recyclerView);
        //设置item点击事件
        newListAdapter.setOnNewItemClickListener(new OnNewItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, New newItem) {
                Intent intent = new Intent(getActivity(), NewsInfoActivity.class);
                intent.putExtra("title",newItem.getTitle());
                intent.putExtra("img", newItem.getIcon());
                intent.putExtra("content",newItem.getContent());
                startActivity(intent);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(newListAdapter);
    }
}
