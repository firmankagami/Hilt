package com.firmankagami.hilt.network

import com.firmankagami.hilt.model.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //get list users with query
    @GET("api/users")
    suspend fun getListUsers(@Query("page") page: String): ResponseUser
}