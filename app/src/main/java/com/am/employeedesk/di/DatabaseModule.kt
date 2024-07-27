package com.am.employeedesk.di

import android.content.Context
import androidx.room.Room
import com.am.employeedesk.database.AppDataBase
import com.am.employeedesk.database.EmployeeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataBase {
        return Room.databaseBuilder(appContext, AppDataBase::class.java, "Employee")
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideChannelDao(appDataBase: AppDataBase): EmployeeDao {
        return appDataBase.employeeDao
    }


}