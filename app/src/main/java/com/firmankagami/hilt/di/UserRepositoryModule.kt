package com.firmankagami.hilt.di

import com.firmankagami.hilt.repository.UserRepository
import com.firmankagami.hilt.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(repo: UserRepositoryImpl): UserRepository

}