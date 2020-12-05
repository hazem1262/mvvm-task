package com.example.mvvmstarterproject.ui.sendMessage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mvvmstarterproject.R
import com.example.mvvmstarterproject.base.BaseFragment
import kotlinx.android.synthetic.main.send_message_fragment.*

class SendMessageFragment : BaseFragment<SendMessageViewModel>() {

    private val messagesAdapter = MessagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_message_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpMessagesAdapter()
        handleSendMessageBtn()
        handleBackButton()
    }

    private fun handleBackButton() {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun handleSendMessageBtn() {
        messageMeBtn.setOnClickListener {
            val selectedMessage = messagesAdapter.currentList.find { it.isSelected }?.also {
                Toast.makeText(requireContext(), "selected index is: ${messagesAdapter.currentList.indexOf(it)}, value: ${it.subHeader}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setUpMessagesAdapter() {
        viewModel.getMessages()
        messagesTypes.adapter = messagesAdapter
        viewModel.messagesLiveData.observe(viewLifecycleOwner, Observer {
            messagesAdapter.submitList(it)
        })
    }

}