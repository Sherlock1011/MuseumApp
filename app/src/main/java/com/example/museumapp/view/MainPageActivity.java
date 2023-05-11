package com.example.museumapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.museumapp.R;
import com.example.museumapp.view.adapter.MyFragmentAdapter;
import com.example.museumapp.view.fragments.CpFragment;
import com.example.museumapp.view.fragments.MainPageFragment;
import com.example.museumapp.view.fragments.NewsFragment;
import com.example.museumapp.view.fragments.OrderFragment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {
    private String user_id;
    private QMUIViewPager viewPager;
    private RadioGroup bottom_tool;

    private List<Fragment> fragmentList;

    private FragmentPagerAdapter fpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        StatusBarManager.setStatusBarFull(MainPageActivity.this, getWindow(), getResources());
        //获取传来的user_id
        getUserId();

        initViews();


    }

    /**
     * 获取传来的user_id
     */
    private void getUserId(){
        user_id = getIntent().getStringExtra("user_id");
    }

    /**
     * 初始化界面控件
     */
    private void initViews(){
        viewPager = (QMUIViewPager) findViewById(R.id.fragment_vp);
        bottom_tool = (RadioGroup) findViewById(R.id.bottom_tool);
        //初始化fragment
        initFragments();
        //设置fragment适配器，将fragment与ViewPager、Radiobutton绑定在一起
        initFragmentPagerAdapter();
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        fragmentList = new ArrayList<>();

        fragmentList.add(new MainPageFragment());
        fragmentList.add(new CpFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new OrderFragment());
    }

    /**
     * initial fragmentAdapter
     */
    private void initFragmentPagerAdapter(){
        fpAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fpAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        bottom_tool.setOnCheckedChangeListener(checkedChangeListener);
    }

    /**
     * 设置ViewPager监听器
     */
    private QMUIViewPager.OnPageChangeListener pageChangeListener = new QMUIViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            RadioButton radioButton = (RadioButton)bottom_tool.getChildAt(position);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * 设置RadioGroup监听器
     */
    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
            for(int i = 0; i < radioGroup.getChildCount();i++){
                if(radioGroup.getChildAt(i).getId() == checkId){
                    viewPager.setCurrentItem(i);
                    return;
                }
            }
        }
    };

}