package com.test.kotlinex.RecyclerView


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OneModelItem(
    @SerializedName("body")
    var body: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("userId")
    var userId: Int? = null
) : Serializable