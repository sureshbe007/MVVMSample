package com.example.mvvmsample.di.module;


import android.app.Application;
import android.content.Context;

import com.example.mvvmsample.data.AppDataManager;
import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.data.local.pref.AppPreferencesHelper;
import com.example.mvvmsample.data.local.pref.PreferencesHelper;
import com.example.mvvmsample.data.remote.ApiHeader;
import com.example.mvvmsample.data.remote.ApiHelper;
import com.example.mvvmsample.data.remote.AppApiHelper;
import com.example.mvvmsample.utils.AppConstant;
import com.example.mvvmsample.utils.rx.AppSchedulerProvider;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

//    private ApiHeader mApiHeader;

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    String providePreferenceName() {

        return AppConstant.PREF_NAME;
    }
}
