package com.example.mvvmstarterproject.data

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("id")
    val id:Int,
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("title")
    val header:String,
    @SerializedName("body")
    val subHeader:String,
    var isSelected:Boolean = false
){
    override fun equals(other: Any?): Boolean {
        if (other is Message){
            return  other.id == this.id && other.isSelected == this.isSelected
        }
        return super.equals(other)
    }
}