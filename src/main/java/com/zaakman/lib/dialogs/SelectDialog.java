package com.zaakman.lib.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.zaakman.lib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaakMan on 2017/8/7.
 */

public class SelectDialog extends DialogFragment {

    private View mRootView = null;

    private LinearLayout mLayout = null;

    private ListView mListView = null;

    private List<String> mSelectItem = new ArrayList<>();

    private SelectAdapter mAdapter = new SelectAdapter();

    private SelectItemListener mListener = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mRootView = inflater.inflate(R.layout.dialog_select, null);
        mLayout = (LinearLayout) mRootView.findViewById(R.id.ll_contain);
        initView();
        return mRootView;
    }

    private void initView() {
        mListView = (ListView) mRootView.findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            if (mListener != null) {
                mListener.onSelect(position, mSelectItem.get(position));
            }
        });
    }

    public void setDatas(String... str) {
        for (String item : str) {
            mSelectItem.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }

    class SelectAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return mSelectItem.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();
                convertView = getActivity().getLayoutInflater().inflate(R.layout.item_select_dialog, null);
                holder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            String item = mSelectItem.get(position);
            holder.tv_item.setText(item);
            return convertView;
        }

    }


    class Holder {
        TextView tv_item;
    }

    public void setListener(SelectItemListener listener) {
        mListener = listener;
    }

    public interface SelectItemListener {
        void onSelect(int pos, String item);
    }


}
