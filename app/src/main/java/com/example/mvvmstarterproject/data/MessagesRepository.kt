package com.example.mvvmstarterproject.data

import com.example.mvvmstarterproject.base.BaseRepository
import com.example.mvvmstarterproject.utils.ConnectivityUtils
import com.example.mvvmstarterproject.utils.network.ApplicationException
import com.example.mvvmstarterproject.utils.network.ErrorType
import com.example.mvvmstarterproject.utils.network.Result
import javax.inject.Inject

class MessagesRepository @Inject constructor(connectivityUtils: ConnectivityUtils, private val messagesService: MessagesService): BaseRepository(connectivityUtils) {
    suspend fun getListOfUsers(): Result<List<Message>> {
        return safeApiCall {
            messagesService.getListOfMessages()
        }.let { result ->
            when (result) {
                is Result.Success -> Result.Success(result.data)
                is Result.Error -> result
                else -> Result.Error(ApplicationException(type = ErrorType.Unexpected))
            }
        }
    }
}