package com.zaakman.lib.thirdpart;

import android.content.Context;

import com.tencent.stat.MtaSDkException;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatCrashReporter;
import com.tencent.stat.StatService;

/**
 * Created by ZaakMan on 2017/7/25.
 */

public class Analytics {

    private Context mContext = null;

    private static Analytics sAnalytics = null;

    private Analytics(Context activity) {
        this.mContext = activity;
    }

    public static Analytics getInstance(Context context) {
        if (sAnalytics == null) {
            sAnalytics = new Analytics(context);
        }
        return sAnalytics;
    }


    public void init() {
        try {
            StatConfig.setAppKey(mContext, "A15DAY5WE1VW");
            StatConfig.setInstallChannel(mContext, "MY_CHANNEL");
            StatConfig.setDebugEnable(false);
            StatService.startStatService(mContext, "A15DAY5WE1VW", com.tencent.stat.common.StatConstants.VERSION);
            StatCrashReporter.getStatCrashReporter(mContext.getApplicationContext()).setEnableInstantReporting(true);
            StatCrashReporter.getStatCrashReporter(mContext.getApplicationContext()).setJavaCrashHandlerStatus(true);
        } catch (MtaSDkException e) {
            e.printStackTrace();
        }
    }
}
