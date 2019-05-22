package com.example.mvvmsample.data.remote;

import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.data.model.api.LoginResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<LoginResponse> doServerLoginApiCall(LoginRequest loginRequest);
}
