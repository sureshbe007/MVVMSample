package com.example.mvvmsample.ui.login;

import android.text.TextUtils;

import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.ui.base.BaseViewModel;
import com.example.mvvmsample.utils.CommonUtils;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isLoginValid(String userName, String email, String mobileNumber, String password) {
        // validate email and password

        if (TextUtils.isEmpty(userName)) {
            return false;
        }

        if (TextUtils.isEmpty(mobileNumber)) {
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        return !TextUtils.isEmpty(password);
    }


    public void login(String userName, String email, String mobileNumber, String password) {
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest(userName, email, mobileNumber, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    getNavigator().openMainActivity();
                }, throwable -> {
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }


}
