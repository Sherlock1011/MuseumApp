package com.example.museumapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.museumapp.R;

public class NewsInfoActivity extends AppCompatActivity {
    private TextView title_tv;
    private ImageView new_img;
    private TextView content_tv;

    private String title;
    private int imgId;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        StatusBarManager.setStatusBarFull(NewsInfoActivity.this, getWindow(), getResources());

        getNewsInfo();
        initViews();
    }

    /**
     * 获取上个界面中传来的新闻详情
     */
    private void getNewsInfo() {
        title = getIntent().getStringExtra("title");
        imgId = getIntent().getIntExtra("img", R.drawable.n1);
        content = getIntent().getStringExtra("content");
    }

    /**
     * 初始化界面控件
     */
    private void initViews(){
        title_tv = (TextView) findViewById(R.id.new_title_tv);
        new_img = (ImageView) findViewById(R.id.new_img);
        content_tv = (TextView) findViewById(R.id.new_content_tv);

        title_tv.setText(title);
        new_img.setImageResource(imgId);
        content_tv.setText(content);
    }
}