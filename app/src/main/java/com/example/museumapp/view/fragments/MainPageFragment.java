package com.example.museumapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.museumapp.R;

public class MainPageFragment extends Fragment {
    private WebView webView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        initViews(view);
        return view;
    }

    /**
     * 初始化界面控件
     * @param view
     */
    private void initViews(View view) {
        webView = (WebView) view.findViewById(R.id.webview);

        initWebView();

        loadWebPage(webView, "https://baike.baidu.com/item/%E5%AE%81%E5%BE%B7%E5%B8%82%E5%8D%9A%E7%89%A9%E9%A6%86/10582315?fr=aladdin");
    }

    /**
     * 设置webView相关属性
     */
    private void initWebView(){
        //设置页面适应屏幕
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        //放大设置
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
    }

    /**
     * 加载网页
     * @param webView 网站显示控件
     * @param url 网址
     */
    private void loadWebPage(WebView webView, String url){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);
    }
}
