package com.friendtime.sdk.app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import com.friendtime.sdk.activity.NewsActivity;
import com.friendtime.sdk.R;
import com.friendtime.sdk.utils.DialogUtil;
import com.friendtime.sdk.view.GestureImageView;

public class StandardImageXML extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.standard_image);

        GestureImageView gestureImageView = (GestureImageView) findViewById(R.id.image);
        AbsoluteLayout layout = (AbsoluteLayout) findViewById(R.id.layout);
        ImageView imageViewSwing = new ImageView(this);
       // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50,0,0);
        imageViewSwing.setLayoutParams(new AbsoluteLayout.LayoutParams(100, 100, 500, 700));
        imageViewSwing.setImageResource(R.mipmap.jia);
        layout.addView(imageViewSwing);


        ImageView imageViewRoof = new ImageView(this);
        // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50,0,0);
        imageViewRoof.setLayoutParams(new AbsoluteLayout.LayoutParams(100, 100, 150, 900));
        imageViewRoof.setImageResource(R.mipmap.jia);
        layout.addView(imageViewRoof);

        ImageView imageViewWare = new ImageView(this);
        // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50,0,0);
        imageViewWare.setLayoutParams(new AbsoluteLayout.LayoutParams(100, 100, 800, 1200));
        imageViewWare.setImageResource(R.mipmap.jia);
        layout.addView(imageViewWare);

        imageViewSwing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = DialogUtil.getCustomeDilogForNormal(StandardImageXML.this);
                dialog.show();
            }
        });

        imageViewRoof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = DialogUtil.getCustomeDilog(StandardImageXML.this);
                dialog.show();

            }
        });

        imageViewWare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardImageXML.this, NewsActivity.class);
                startActivity(intent);
            }
        });


    }
}