package com.friendtime.sdk.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.friendtime.http.HttpUtility;
import com.friendtime.sdk.R;
import com.friendtime.sdk.view.ProgressWebView;

/**
 * Created by wutao on 2016/2/25.
 */
public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        ProgressWebView progressWebView = (ProgressWebView) findViewById(R.id.webview);
        progressWebView.loadUrl("http://www.davco.cn/news_list/newsCategoryId=5.html");


    }


}
