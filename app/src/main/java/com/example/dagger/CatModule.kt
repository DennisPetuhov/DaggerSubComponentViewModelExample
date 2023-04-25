package com.example.dagger

import dagger.Module
import dagger.Provides

@Module // предоставляет зависимости Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
//Модули - это просто классы, в которые мы выносим (из Activity) код создания объектов.
// Обычно каждый модуль включает в себя создание объектов близких по смыслу

class CatModule {
    @Provides //создадим зависимость и ложим в контектс дагера.
    // аннотация @Provides указывает, что метод является поставщиком объекта.
    fun provideCat(myClass: MyClass): Cat {

        return Cat(myClass)
    }
}