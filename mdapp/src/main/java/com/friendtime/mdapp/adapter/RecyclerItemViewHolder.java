package com.friendtime.mdapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.friendtime.mdapp.R;


/**
 * Created by lgp on 2015/4/6.
 */
public class RecyclerItemViewHolder extends RecyclerView.ViewHolder{

    private final TextView mItemTextView;
    public RecyclerItemViewHolder(View parent) {
        super(parent);
        mItemTextView = (TextView) parent.findViewById(R.id.itemTextView);
    }
    public void setItemText(CharSequence text){
        if (mItemTextView != null)
            mItemTextView.setText(text);
    }
    public void setItemText(int text){
        if (mItemTextView != null)
            mItemTextView.setText(text);
    }
}
