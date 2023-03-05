package io.github.janbarari.decoupledmvisample.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.janbarari.decoupledmvisample.home.data.HomeRepositoryImpl
import io.github.janbarari.decoupledmvisample.home.data.remote.HomeRemoteDataSource
import io.github.janbarari.decoupledmvisample.home.data.remote.HomeRemoteDataSourceImpl
import io.github.janbarari.decoupledmvisample.home.domain.repository.HomeRepository

@Module
@InstallIn(SingletonComponent::class)
interface HomeModule {

    @Binds
    fun provideHomeDataSource(impl: HomeRemoteDataSourceImpl): HomeRemoteDataSource

    @Binds
    fun provideHomeRepository(impl: HomeRepositoryImpl): HomeRepository

}