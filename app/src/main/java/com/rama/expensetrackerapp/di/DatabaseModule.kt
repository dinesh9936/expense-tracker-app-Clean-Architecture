package com.rama.expensetrackerapp.di

import android.content.Context
import androidx.room.Room
import com.rama.expensetrackerapp.ExpenseTrackerApp
import com.rama.expensetrackerapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "expense_tracker_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExpenseDao(database: AppDatabase) = database.expenseDao()
}