package com.example.buoi_10.ui.cach_3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cach 3: Gọi trực tiếp phương thức Listener của view");
    }

    public LiveData<String> getText() {
        return mText;
    }
}