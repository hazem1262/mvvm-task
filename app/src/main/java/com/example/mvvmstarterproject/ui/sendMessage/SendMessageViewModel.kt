package com.example.mvvmstarterproject.ui.sendMessage

import com.example.mvvmstarterproject.base.BaseViewModel
import com.example.mvvmstarterproject.data.Message
import javax.inject.Inject

class SendMessageViewModel @Inject constructor(): BaseViewModel() {
    fun getMessagesOptions(): List<Message> {
        return arrayListOf(
            Message(
                id = 1,
                header = "Question",
                subHeader = "Message with a reply",
                price = 2
            ),
            Message(
                id = 2,
                header = "Question",
                subHeader = "Message only",
                price = 1
            ),
            Message(
                id = 3,
                header = "Question",
                subHeader = "Message with a reply with order",
                price = 3
            )
        )
    }

}