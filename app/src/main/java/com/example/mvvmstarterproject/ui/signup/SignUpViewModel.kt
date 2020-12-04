package com.example.mvvmstarterproject.ui.signup

import com.example.mvvmstarterproject.base.BaseViewModel
import javax.inject.Inject

class SignUpViewModel @Inject constructor(): BaseViewModel() {
    fun isValidForm(): Boolean {
        return true
    }

    var selectedImagePath:String = ""
}