package com.rushi.pharmahub.di

import com.rushi.pharmahub.repository.Repo
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
	fun ProvideRepo(): Repo {
		return Repo()
	}
}