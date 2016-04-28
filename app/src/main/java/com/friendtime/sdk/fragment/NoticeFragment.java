package com.friendtime.sdk.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.friendtime.sdk.R;
import com.friendtime.sdk.widget.LoadFragment;

/**
 * Created by wutao on 2016/4/19.
 */
public class NoticeFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        return rootView;

    }

}
