package com.example.mvvmsample.data;

import android.content.Context;

import com.example.mvvmsample.data.local.db.DbHelper;
import com.example.mvvmsample.data.local.pref.PreferencesHelper;
import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.data.model.api.LoginResponse;
import com.example.mvvmsample.data.remote.ApiHelper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public abstract class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

@Inject
    public AppDataManager(ApiHelper mApiHelper, Context mContext, DbHelper mDbHelper, Gson mGson, PreferencesHelper mPreferencesHelper) {
        this.mApiHelper = mApiHelper;
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mGson = mGson;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest request) {
        return mApiHelper.doServerLoginApiCall(request);
    }
}
