package com.example.dagger

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module

abstract class ViewModelModule  {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: MyDaggerViewModelFactory):ViewModelProvider.Factory
}