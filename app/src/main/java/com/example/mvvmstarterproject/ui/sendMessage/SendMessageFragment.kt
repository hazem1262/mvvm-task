package com.example.mvvmstarterproject.ui.sendMessage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmstarterproject.R

class SendMessageFragment : Fragment() {

    companion object {
        fun newInstance() = SendMessageFragment()
    }

    private lateinit var viewModel: SendMessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_message_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SendMessageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}