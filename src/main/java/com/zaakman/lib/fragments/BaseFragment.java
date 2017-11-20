package com.zaakman.lib.fragments;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ZaakMan on 2017/8/15.
 */

public class BaseFragment extends Fragment {

    private View mRootView = null;

    /**
     * 返回flase就是继续调用Activity的返回操作
     * @return
     */
    public boolean backAction(){
        return false;
    }

    protected View infateView(LayoutInflater inflater, ViewGroup container,int layoutId){
        mRootView = inflater.inflate(layoutId, container, false);
        return mRootView;
    }

    protected View getRootView(){
        return mRootView;
    }

    protected <T extends View> T find(int id){
        return (T)mRootView.findViewById(id);
    }

}
