package com.firmankagami.hilt.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.firmankagami.hilt.model.ResponseUser
import com.firmankagami.hilt.network.ApiService
import com.firmankagami.hilt.utils.Result
import java.lang.Exception
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService): UserRepository {

    override fun getUserList(page: String): LiveData<Result<ResponseUser>> = liveData {
        try {
            val userResponse = apiService.getListUsers(page)
            emit(Result.Success(userResponse))

        } catch (e: Exception){
            Log.d("UserRepository", "getError ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
        }
    }
}