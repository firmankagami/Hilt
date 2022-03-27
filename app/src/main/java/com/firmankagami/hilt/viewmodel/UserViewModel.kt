package com.firmankagami.hilt.viewmodel

import androidx.lifecycle.ViewModel
import com.firmankagami.hilt.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor (
    private val userRepository: UserRepository
    ): ViewModel() {

    fun getUserList(page: String) = userRepository.getUserList(page)
}