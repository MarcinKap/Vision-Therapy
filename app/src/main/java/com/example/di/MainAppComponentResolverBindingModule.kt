package com.example.di

import com.example.bottomnaviagtionbar.BottomNavigationElementComposer
import com.example.bottomnaviagtionbar.NavigationElementComposer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal interface MainAppComponentResolverBindingModule {

    @Binds
    @Singleton
    fun bindNavigationElementComposer(
        bottomNavigationElementComposer: BottomNavigationElementComposer,
    ): NavigationElementComposer
}