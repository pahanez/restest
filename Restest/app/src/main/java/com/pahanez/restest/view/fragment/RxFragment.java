package com.pahanez.restest.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pahanez.restest.R;
import com.pahanez.restest.di.component.RxComponent;
import com.pahanez.restest.view.RxView;
import com.pahanez.restest.view.presenter.RxPresenter;

import javax.inject.Inject;


/**
 * Demo rx fragment;
 */
public class RxFragment extends BaseFragment implements RxView, View.OnClickListener {

    private Button mB1;
    private Button mB2;
    private Button mB3;
    private Button mB4;

    @Inject
    RxPresenter mRxPresenter;

    public static RxFragment newInstance() {
        RxFragment rxFragment = new RxFragment();
        return rxFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gc_test, container, false);
        this.setupUI(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initialize();
    }

    private void initialize() {
        this.getComponent(RxComponent.class).inject(this);
        this.mRxPresenter.setView(this);
    }

    private void setupUI(View view) {
        mB1 = (Button) view.findViewById(R.id.button1);
        mB2 = (Button) view.findViewById(R.id.button2);
        mB3 = (Button) view.findViewById(R.id.button3);
        mB4 = (Button) view.findViewById(R.id.button4);

        mB1.setOnClickListener(this);
        mB2.setOnClickListener(this);
        mB3.setOnClickListener(this);
        mB4.setOnClickListener(this);
    }

    @Override
    public void renderResponse(Object object) {
        System.out.println("renderResponse");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                    this.mRxPresenter.onB1Clicked();
                break;
            case R.id.button2:
                this.mRxPresenter.onB2Clicked();
                break;
        }
    }
}
