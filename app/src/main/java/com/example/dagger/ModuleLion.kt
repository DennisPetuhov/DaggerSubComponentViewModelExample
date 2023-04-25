package com.example.dagger

import dagger.Module
import dagger.Provides

@Module

class ModuleLion {
    @LionScope // экземпляр будет храниться в памяти ровно столько сколько будет рабоать субмодуль
    @Provides
    fun mewLion():Lion{
        return Lion(10,20)
    }
}