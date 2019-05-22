package com.example.mvvmsample.ui.login;

public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void openMainActivity();
}
