package com.example.mvvmstarterproject.data

import retrofit2.Response
import retrofit2.http.GET

interface MessagesService {

    @GET("posts")
    suspend fun getListOfMessages(): Response<List<Message>>
}