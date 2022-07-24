package com.example.buoi_10.ui.cach_1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cách 1: Đăng ký trực tiếp trong XML");
    }

    public LiveData<String> getText() {
        return mText;
    }
}