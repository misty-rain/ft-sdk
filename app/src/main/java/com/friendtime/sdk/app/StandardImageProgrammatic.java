package com.friendtime.sdk.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.friendtime.sdk.R;
import com.friendtime.sdk.utils.ImageUtil;
import com.friendtime.sdk.view.GestureImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StandardImageProgrammatic extends ExampleActivity {

    protected GestureImageView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        view = new GestureImageView(this);

        Bitmap mark = BitmapFactory.decodeResource(this.getResources(), R.mipmap.image);
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(), R.mipmap.jia);

        Bitmap c = ImageUtil.createWaterMaskRightBottom(this,mark,photo,0,0);
        view.setImageBitmap(c);

        Button btnTest =  new Button(this);
        LayoutParams btnParams = new LayoutParams(0,0);
        btnTest.setLayoutParams(btnParams);
        btnTest.setText("hahah");
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StandardImageProgrammatic.this,"hha",200).show();
            }
        });


        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);

       // layout.addView(view);
        layout.addView(btnTest);




    }



    private Bitmap createBitmap(Bitmap src, Bitmap watermark)

    {

        String tag = "createBitmap";

        // Log.d( tag, "create a new bitmap" );

        if (src == null)

        {

            return null;

        }

        int w = src.getWidth();

        int h = src.getHeight();

        int ww = watermark.getWidth();

        int wh = watermark.getHeight();

        //create the new blank bitmap

        Bitmap newb = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        //创建一个新的和SRC长度宽度一样的位图

        Canvas cv = new Canvas(newb);

        //draw src into

        cv.drawBitmap(src, 0, 0, null);//在 0，0坐标开始画入src

        //draw watermark into

        cv.drawBitmap(watermark, w - ww + 5, h - wh + 5, null);//在src的右下角画入水印

        //save all clip

        cv.save(Canvas.ALL_SAVE_FLAG);//保存

        //store

        cv.restore();//存储

        return newb;

    }


//保存图片到data下面


    public void saveMyBitmap(Bitmap bmp) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("image1.jpg", Context.MODE_PRIVATE);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (FileNotFoundException e) {
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                }
            }
        }

    }

}