package com.example.mvvmsample.data;

import com.example.mvvmsample.data.local.db.DbHelper;
import com.example.mvvmsample.data.local.pref.PreferencesHelper;
import com.example.mvvmsample.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {



}
