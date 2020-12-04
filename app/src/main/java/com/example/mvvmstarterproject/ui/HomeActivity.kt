package com.example.mvvmstarterproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmstarterproject.R
import com.example.mvvmstarterproject.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}