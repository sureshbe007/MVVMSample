package com.example.mvvmsample.data.remote;


import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.data.model.api.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Single;

public class AppApiHelper implements ApiHelper{

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest loginRequest) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.BASE_URL)
//                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(loginRequest)
                .build()
                .getObjectSingle(LoginResponse.class);
    }
}
