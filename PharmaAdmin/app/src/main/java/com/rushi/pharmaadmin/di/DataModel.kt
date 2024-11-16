package com.rushi.pharmaadmin.di


import com.rushi.pharmaadmin.repository.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
	@Singleton
	@Provides
	fun provideRepo() : Repo {
		return Repo()
	}
}