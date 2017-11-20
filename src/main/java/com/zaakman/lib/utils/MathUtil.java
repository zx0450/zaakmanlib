package com.zaakman.lib.utils;

/**
 * Created by ZaakMan on 2017/9/14.
 */

public class MathUtil {

    public static String PriceFormat(float n){
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        return df.format(n);
    }
}
