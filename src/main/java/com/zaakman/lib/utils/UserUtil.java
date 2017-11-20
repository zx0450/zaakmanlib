package com.zaakman.lib.utils;

import android.content.Context;

import com.zaakman.lib.data.DataHelper;

/**
 * Created by ZaakMan on 2017/8/8.
 * 用户相关工具类
 */

public class UserUtil {
    //获取Token
    public static String GetToken(Context context) {
        return DataHelper.getInstance(context).restore(DataHelper.KEY_TOKEN, "");
    }

    //获取登录失效时间戳
    public static long GetExpirationTime(Context context) {
        return DataHelper.getInstance(context).restore(DataHelper.KEY_EXPIRATION_TIME, 0);
    }

    //是否自动绑定
    public static boolean isAutoBinding(Context context) {
        return DataHelper.getInstance(context).restore(DataHelper.KEY_AUTO_BINDING, false);
    }

    //设置自动绑定
    public static void setAutoBinding(Context context, boolean value) {
        DataHelper.getInstance(context).save(DataHelper.KEY_AUTO_BINDING, value);
    }

    public static String GetUserAccount(Context context){
        return DataHelper.getInstance(context).restore(DataHelper.KEY_LOGIN_NAME,"");
    }
}
