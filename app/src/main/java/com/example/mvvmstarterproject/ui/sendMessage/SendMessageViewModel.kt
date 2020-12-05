package com.example.mvvmstarterproject.ui.sendMessage

import androidx.lifecycle.MutableLiveData
import com.example.mvvmstarterproject.base.BaseViewModel
import com.example.mvvmstarterproject.data.Message
import com.example.mvvmstarterproject.data.MessagesRepository
import javax.inject.Inject

class SendMessageViewModel @Inject constructor(private val messagesRepository: MessagesRepository): BaseViewModel() {

    val messagesLiveData: MutableLiveData<List<Message>> = MutableLiveData()

    fun getMessages(){
        wrapBlockingOperation {
            handleResult(messagesRepository.getListOfUsers()){
                messagesLiveData.postValue(it.data)
            }
        }
    }
}