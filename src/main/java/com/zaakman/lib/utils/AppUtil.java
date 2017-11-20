package com.zaakman.lib.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;

import com.bulong.rudeness.RudenessScreenHelper;

/**
 * Created by ZaakMan on 2017/8/8.
 * App相关工具类
 */

public class AppUtil {
    public static int GetVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static String GetVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0";
    }

    public static void ScreenAdatperStart(Application app , int designWidth){
        new RudenessScreenHelper(app, designWidth).activate();
    }

}
