package com.firmankagami.hilt.repository

import androidx.lifecycle.LiveData
import com.firmankagami.hilt.model.ResponseUser
import com.firmankagami.hilt.utils.Result

interface UserRepository {
    fun getUserList(page: String): LiveData<Result<ResponseUser>>
}