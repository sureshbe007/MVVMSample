package com.example.mvvmsample.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmsample.BR;
import com.example.mvvmsample.R;
import com.example.mvvmsample.ViewModelProviderFactory;
import com.example.mvvmsample.databinding.ActivityLoginBinding;
import com.example.mvvmsample.ui.base.BaseActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {

        return new Intent(context, LoginActivity.class);
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {

        mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {

        String name = mActivityLoginBinding.etName.getText().toString();
        String email = mActivityLoginBinding.etEmail.getText().toString();
        String mobile = mActivityLoginBinding.etMobile.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();
        if (mLoginViewModel.isLoginValid( name,  email,  mobile,  password)) {
            mLoginViewModel.login(name,email,mobile, password);
        }
        else {
            Toast.makeText(this, "Enter Valild Details", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void openMainActivity() {

    }
}
