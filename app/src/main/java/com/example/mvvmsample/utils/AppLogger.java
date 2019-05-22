package com.example.mvvmsample.utils;

import timber.log.BuildConfig;
import timber.log.Timber;

public final class AppLogger {


    private AppLogger() {

    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
