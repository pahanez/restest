package com.pahanez.restest.gc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pahanez.restest.R;

/**
 * Created by pindziukou on 05/12/15.
 */
public class GcTestActivity2 extends AppCompatActivity {
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
                openSelf();
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


    private void malloc20mb() {
        bytes[pos++] = new byte[20000000];
    }

    private void malloc2mb() {
        bytes[pos++] = new byte[2000000];
    }

    private void openSelf() {
        startActivity(new Intent(this, GcTestActivity1.class));
    }
}
