package com.zaakman.lib.view.selector;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ZaakMan on 2017/8/11.
 */

public class TextViewSelector {

    public static void setBackground(TextView textView, int normalId, int pressedId) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable selected = textView.getContext().getResources().getDrawable(pressedId);
        Drawable unSelected = textView.getContext().getResources().getDrawable(normalId);
        drawable.addState(new int[]{android.R.attr.state_pressed},
                selected);
        drawable.addState(new int[]{},
                unSelected);
        textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
    }

    public static void setTextColor(TextView textView, int colorNomalId, int colorPressedId) {
        ColorStateList colorList = new ColorStateList(new int[][]{
                new int[]{android.R.attr.state_pressed},
                new int[]{}
        }, new int[]{
                textView.getContext().getResources().getColor(colorPressedId),
                textView.getContext().getResources().getColor(colorNomalId)
        });
        textView.setTextColor(colorList);
    }


}
