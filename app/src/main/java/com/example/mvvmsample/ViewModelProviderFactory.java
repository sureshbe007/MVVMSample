package com.example.mvvmsample;

import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {


    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }
}
