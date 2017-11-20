package com.zaakman.lib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ZaakMan on 2017/8/9.
 * 普通工具类
 */

public class CommentUtil {
    public static String TransErrorToCNString(String errorStr) {
        if (errorStr.contains("NoConnectionError")) {
            return "未能访问服务器";
        }
        if (errorStr.equals("RESOURCE_NOT_FOUND")) {
            return "二维码不存在";
        }
        if (errorStr.contains("TimeoutError")) {
            return "访问超时";
        }
        if (errorStr.contains("TimeoutError")) {
            return "访问超时";
        }
        if (errorStr.contains("UNKOWN_ACCOUNT")) {
            return "账号或密码错误";
        }
        if (errorStr.contains("ServerError")) {
            return "服务器错误";
        }
        return "未知错误";
    }


    public static Toast toast;

    /**
     * 吐丝的方法，可以避免重复吐丝。当你点击多次按钮的时候，吐丝只出现一次。
     *
     * @param context 上下文对象
     * @param string  吐丝的内容
     */
    public static void ShowToast(Context context, String string) {
        if(context == null) return;
        if (toast == null) {
            // 如果Toast对象为空了，那么需要创建一个新的Toast对象
            toast = Toast.makeText(context, string, Toast.LENGTH_LONG);
        } else {
            // 如果toast对象还存在，那么就不再创建新的Toast对象
            toast.setText(string);
        }
        // 最后调用show方法吐丝
        toast.show();
    }

}
