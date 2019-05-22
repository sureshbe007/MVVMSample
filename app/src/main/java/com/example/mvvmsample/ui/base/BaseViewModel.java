package com.example.mvvmsample.ui.base;

import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {


    private final DataManager mDataManager;

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;


    public BaseViewModel(DataManager mDataManager, SchedulerProvider mSchedulerProvider) {
        this.mSchedulerProvider = mSchedulerProvider;
        this.mDataManager = mDataManager;
        this.mCompositeDisposable = new CompositeDisposable();

    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {

        return mDataManager;
    }

    public N getNavigator() {

        return mNavigator.get();
    }

    public void setNavigator(N navigator) {

        this.mNavigator = new WeakReference<>(navigator);
    }

    public SchedulerProvider getSchedulerProvider() {

        return mSchedulerProvider;
    }

}
