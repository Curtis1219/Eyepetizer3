package com.example.administrator.eyepetizer.moduls.attention.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CricleTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap bitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (bitmap != source) {
            source.recycle();//回收之前的图片
        }
        Bitmap result = Bitmap.createBitmap(size,size,bitmap.getConfig());
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        //图片渲染
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float radius = size/2;
        canvas.drawCircle(radius,radius,radius,paint);
        bitmap.recycle();
        return result;
    }
    @Override
    public String key() { return "CricleTransformation"; }
}
