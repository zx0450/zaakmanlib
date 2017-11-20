package com.zaakman.lib.view.selector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZaakMan on 2017/9/11.
 */

public class DiverMutiPoint extends View {

    private Paint mPaint;

    private float mGap = 5;

    public DiverMutiPoint(Context context) {
        super(context);
        init();
    }

    public DiverMutiPoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiverMutiPoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint(Color.parseColor("#666666"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float length = 0;
        while (length < width){
            canvas.drawPoint(length,height/2,mPaint);
            length = length + mGap;
        }

    }
}
