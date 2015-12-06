package com.pahanez.restest.gc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pahanez.restest.R;
import com.pahanez.restest.activity.AuthActivity;

/**
 * Created by pindziukou on 04/12/15.
 */
public class GcTestActivity1 extends AppCompatActivity {

    private static final String TAG = GcTestActivity1.class.getSimpleName();

    private GcItem mGcItem = new GcItem(TAG);
    private int pos = 0;
    byte [][] bytes = new byte[100][];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gc_test);
    }

    public void clickb(View view) {
        switch (view.getId()) {
            case R.id.button1:
                openAuth();
                break;
            case R.id.button2:
                malloc20mb();
                break;
            case R.id.button3:
                malloc2mb();
                break;
            case R.id.button4:

                break;


        }
    }

    private void openAuth() {
        startActivity(new Intent(this, AuthActivity.class));
    }


    private void malloc20mb() {
        bytes[pos++] = new byte[20000000];
    }

    private void malloc2mb() {
        bytes[pos++] = new byte[2000000];
    }

    private void openSelf() {
        startActivity(new Intent(this, GcTestActivity2.class));
    }
}
