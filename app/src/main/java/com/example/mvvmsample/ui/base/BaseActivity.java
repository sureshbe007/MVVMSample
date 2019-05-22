package com.example.mvvmsample.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.mvvmsample.R;
import com.example.mvvmsample.utils.CommonUtils;
import com.example.mvvmsample.utils.NetworkUtils;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements BaseFragment.Callback {

    private ProgressDialog mProgressDialog;
    private T mViewDataBinding;
    private V mViewModel;

    public abstract int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract V getViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDependencyInjection();
        performDataBinding();
    }


    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void performDataBinding() {

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }
}
