package com.example.buoi_10.ui.cach_2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cách 2: Ghi đè phương thức onClick của interface View.OnClickListenner");
    }

    public LiveData<String> getText() {
        return mText;
    }
}