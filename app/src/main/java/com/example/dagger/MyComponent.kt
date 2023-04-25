package com.example.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component

//Activity -> Component -> Module ->
//Компонент - это посредник между Activity и модулями. Когда Activity нужен какой-либо объект,
// она сообщает об этом компоненту. Компонент знает, какой модуль умеет создавать такой объект,
// просит модуль создать объект, и передает его в Activity. При этом компонент может использовать
// другие модули, чтобы создать всю иерархию объектов, необходимую для создания искомого объекта

@Component(modules = [CatModule::class]) // интерфейс посредник между модулями и андройдом, в [] перечисляем все модули
//При компиляции проекта, даггер найдет этот интерфейс по аннотации @Component и сгенерирует класс
// DaggerAppComponent (Dagger + имя интерфейса), который станет реализацией этого интерфейса.
// Этот класс и будет потом создавать объекты и возвращать их нам.


interface MyComponent {
    fun injectFirstActivity(activityFirst: ActivityFirst) // метод с входящим аргументом того типа, где мы хотим делать инджект
    fun injectSecondActivity(activitySecond: ActivitySecond)
    fun lionComponent():LionSubComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance // создаем сами объекты и вкладываем в даггер с помощью BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun myclass(myClass: MyClass): Builder
        fun build(): MyComponent

    }
}