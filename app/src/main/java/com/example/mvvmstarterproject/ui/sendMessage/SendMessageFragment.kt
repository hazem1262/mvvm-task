package com.example.mvvmstarterproject.ui.sendMessage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmstarterproject.R
import com.example.mvvmstarterproject.base.BaseFragment

class SendMessageFragment : BaseFragment<SendMessageViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_message_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}