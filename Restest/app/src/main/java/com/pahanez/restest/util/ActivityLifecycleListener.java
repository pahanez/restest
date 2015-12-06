package com.pahanez.restest.util;

import android.os.Bundle;

public interface ActivityLifecycleListener {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroy();

}
