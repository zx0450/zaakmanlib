//package com.zaakman.lib.thirdpart;
//
//import android.content.Context;
//import android.widget.TextView;
//
//import com.android.tu.loadingdialog.LoadingDailog;
//
///**
// * Created by ZaakMan on 2017/8/1.
// * 封装的等待对话框
// */
//
//public class WaitingDialog {
//
//    private Context mContext = null;
//
//    private LoadingDailog mDialog = null;
//
//    public WaitingDialog(Context context) {
//        this.mContext = context;
//    }
//
//    public WaitingDialog create(String message) {
//        LoadingDailog.Builder loadBuilder = new LoadingDailog.Builder(mContext)
//                .setMessage(message)
//                .setCancelable(true)
//                .setCancelOutside(true);
//        mDialog = loadBuilder.create();
//        return this;
//    }
//
//    public void show() {
//        mDialog.show();
//    }
//
//    public void dismiss() {
//        mDialog.dismiss();
//    }
//
//    public void setMessage(String message) {
//        TextView tv = (TextView) mDialog.findViewById(com.android.tu.loadingdialog.R.id.tipTextView);
//        tv.setText(message);
//    }
//
//
//}
