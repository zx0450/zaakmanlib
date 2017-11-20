package com.zaakman.lib.activitis;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zaakman.lib.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaakMan on 2017/7/27.
 */

public class BaseActivity extends AppCompatActivity {


    private View mActionBarView = null;

    private TextView mTvTitle = null;

    private TextView mTvSetting = null;

    private List<BaseFragment> mFragments = new ArrayList<>();

    private int mContainerId = 0;

    public void setActionBarView(int resId , int titleId , int settingId) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            mActionBarView = getLayoutInflater().inflate(resId, null);
            actionBar.setCustomView(mActionBarView, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));//设置自定义的布局：actionbar_custom
            mTvTitle = find(titleId);
            mTvSetting = find(settingId);
        }
    }

    protected <T extends View> T find(int id){
        return (T)findViewById(id);
    }

    protected void setTitle(String title){
        if (mTvTitle != null){
            mTvTitle.setText(title);
        }
    }

    protected void  setSetting(String setting){
        if (mTvSetting != null){
            mTvSetting.setText(setting);
        }
    }

    protected void setSettingAction(View.OnClickListener listener){
        if (mTvSetting != null){
            mTvSetting.setOnClickListener(listener);
        }
    }


    protected void pushFragment(int container , BaseFragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (mFragments.size() > 0){
            BaseFragment preFragment = mFragments.get(mFragments.size() - 1);
            ft.hide(preFragment);
        }
        mFragments.add(fragment);
        ft.add(container,fragment);
        ft.show(fragment);
        ft.commit();
    }

    private boolean isVisiable = true;

    @Override
    protected void onPause() {
        super.onPause();
        isVisiable = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisiable = true;
    }

    protected boolean pullFragment(){
        BaseFragment fragment = getLastFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.hide(fragment);
        ft.remove(fragment);
        mFragments.remove(fragment);
        if (mFragments.size() > 0){
            fragment = getLastFragment();
            ft.show(fragment);
            ft.commit();
            return true;
        }
        ft.commit();
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            backAction();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private BaseFragment getLastFragment(){
        return mFragments.get(mFragments.size() - 1);
    }

    private void backAction() {
        if (!mFragments.isEmpty() && !getLastFragment().backAction()){  //交给fragment处理这个返回操作
            if (!pullFragment()){
                finish();
            }
        }else{
            finish();
        }
    }

    public void clearFragment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        for (BaseFragment fragment : mFragments){
            ft.hide(fragment);
            ft.remove(fragment);
        }
        mFragments.clear();
        ft.commit();
    }
}
