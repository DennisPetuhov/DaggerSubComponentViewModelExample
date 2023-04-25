package com.example.dagger

import dagger.Subcomponent
import javax.inject.Singleton


@LionScope // все зависимости с этой меткой будут лежать в дагере столько сколько работает этот субкомпонент
@Subcomponent(modules = [ModuleLion::class])


interface LionSubComponent {

    fun injectFragment(blankFragment: BlanckFragment)

    @Subcomponent.Builder

    interface Builder {
        fun build(): LionSubComponent
    }
}