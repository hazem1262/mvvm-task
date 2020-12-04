package com.example.mvvmstarterproject.data

data class Message(
    val id:Int,
    val header:String,
    val subHeader:String,
    val price:Int,
    var isSelected:Boolean = false
)