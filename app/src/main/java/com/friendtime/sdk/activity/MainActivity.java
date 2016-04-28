package com.friendtime.sdk.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.friendtime.http.HttpUtility;
import com.friendtime.http.config.HttpMethod;
import com.friendtime.sdk.R;
import com.friendtime.sdk.fragment.MessageFragment;
import com.friendtime.sdk.fragment.NoticeFragment;
import com.friendtime.sdk.view.ProgressWebView;
import com.friendtime.sdk.web.WebAppInterface;
import com.friendtime.sdk.widget.LoadFragment;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout oneLinearLayout;
    private LinearLayout twoLinearLayout;
    private LinearLayout threeLinearLayout;
    private LinearLayout fourLinearLayout;
    private LoadFragment loadFragment = null;
    private ProgressWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.index);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        WebAppInterface webAppInterface = new WebAppInterface(this);
        webView = (ProgressWebView) findViewById(R.id.webviewtest);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(webAppInterface, "Android");
        webView.loadUrl("http://cwcpf.mhunsha.com");
      //  webView.loadUrl("file:///android_asset/haha.html");
        //initView();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack())
                webView.goBack();
            else
                finish();
        }

        return false;

    }

    private void initView() {
        loadFragment = new LoadFragment(getSupportFragmentManager());
        loadFragment.initFragment(new NoticeFragment());
        oneLinearLayout = (LinearLayout) findViewById(R.id.tab1);
        oneLinearLayout.setOnClickListener(this);
        twoLinearLayout = (LinearLayout) findViewById(R.id.tab2);
        twoLinearLayout.setOnClickListener(this);
        threeLinearLayout = (LinearLayout) findViewById(R.id.tab3);
        threeLinearLayout.setOnClickListener(this);
        fourLinearLayout = (LinearLayout) findViewById(R.id.tab4);
        fourLinearLayout.setOnClickListener(this);
    }


    private void testSyncNetWork() {
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {

                } else if (msg.what == 0) {

                } else if (msg.what == -1) {


                }
            }
        };
        new Thread() {
            public void run() {
                Message msg = new Message();
                try {
                    Response response = HttpUtility.getInstance().syncRequest(HttpMethod.GET, "http://publicobject.com/helloworld.txt", null, null);
                    if (response.isSuccessful()) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

/*

                if (result != null) {s
                } else {
                    msg.what = -1;// 失败
                    msg.obj = getString(R.string.network_error);

                }
*/


                handler.sendMessage(msg);
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                loadFragment.initFragment(new NoticeFragment());
                break;
            case R.id.tab2:
                loadFragment.initFragment(new MessageFragment());
                break;
            case R.id.tab3:
                loadFragment.initFragment(new NoticeFragment());
                break;
            case R.id.tab4:
                loadFragment.initFragment(new MessageFragment());
                break;

            default:
                break;
        }

    }
}
