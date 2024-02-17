package com.test.kotlinex.Util

import com.test.kotlinex.RecyclerView.OneModelItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(API.DATA1)
    fun getDataOne(): Call<List<OneModelItem>>
}