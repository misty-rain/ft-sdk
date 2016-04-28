package com.friendtime.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.friendtime.sdk.R;
import com.friendtime.sdk.widget.CircleLoadingView;

/**
 * Created by wutao on 2016/2/25.
 */
public class ProgressWebView  extends WebView{
    private CircleLoadingView circleLoadingView;

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circleLoadingView = new CircleLoadingView(context,
                  attrs);
        circleLoadingView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                  LayoutParams.MATCH_PARENT, 0, 0));
        addView(circleLoadingView);
        circleLoadingView.startLoading();
        // setWebViewClient(new WebViewClient(){});
        setWebChromeClient(new WebChromeClient());
        //是否可以缩放
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                circleLoadingView.setVisibility(GONE);
            } else {
                if (circleLoadingView.getVisibility() == GONE)
                    circleLoadingView.setVisibility(VISIBLE);
            }
            super.onProgressChanged(view, newProgress);
        }


    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) circleLoadingView.getLayoutParams();
        lp.x = l;
        lp.y = t;
        circleLoadingView.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
