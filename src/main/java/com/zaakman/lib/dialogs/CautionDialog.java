package com.zaakman.lib.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.zaakman.lib.R;


/**
 * Created by ZaakMan on 2017/7/27.
 * 清除数据对话框
 */

public class CautionDialog extends DialogFragment {

    private View rootView = null;

    private TextView tv_content = null;

    private Button bt_cancel, bt_commit;

    private CommitListener mListener = null;

    private String mContent = null;

    private CancelListener mCancelListener = null;

    public static CautionDialog newInstance(CommitListener listener) {
        CautionDialog dialog = new CautionDialog();
        dialog.setCommitListener(listener);
        return dialog;
    }

    private CautionDialog() {

    }

    private void setCommitListener(CommitListener listener) {
        this.mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        rootView = inflater.inflate(R.layout.dialog_simple, null);
        tv_content = (TextView) rootView.findViewById(R.id.tv_content);
        bt_cancel = (Button) rootView.findViewById(R.id.bt_cancel);
        bt_commit = (Button) rootView.findViewById(R.id.bt_commit);
        bt_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCommit(CautionDialog.this);
                dismiss();
            }
        });
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mCancelListener != null) {
                    mCancelListener.onCancel(CautionDialog.this);
                }
            }
        });
        tv_content.setText(mContent);
        return rootView;
    }

    public void setContent(String content) {
        mContent = content;
        if (tv_content != null) {
            tv_content.setText(content);
        }
    }


    public interface CommitListener {
        void onCommit(CautionDialog dialog);
    }

    public interface CancelListener {
        void onCancel(CautionDialog dialog);
    }

    public void setCancelListener(CancelListener listener) {
        mCancelListener = listener;
    }


}
