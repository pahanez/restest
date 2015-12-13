package com.pahanez.restest.view.fragment;

import android.support.v4.app.Fragment;

import com.pahanez.restest.RestestApplication;

/**
 * Created by pindziukou on 11/12/15.
 */
public class BaseFragment extends Fragment {


    private boolean isFragmentAlive() {
        return getActivity() != null && isAdded() && !isDetached() && getView() != null && !isRemoving();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RestestApplication.get(getContext()).wtch(this);
    }
}
