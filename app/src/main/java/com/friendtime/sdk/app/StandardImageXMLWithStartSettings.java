package com.friendtime.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.friendtime.sdk.R;

public class StandardImageXMLWithStartSettings extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.standard_image_with_settings);
    }
}