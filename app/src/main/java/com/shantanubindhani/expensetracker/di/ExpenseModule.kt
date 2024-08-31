package com.shantanubindhani.expensetracker.di

import android.content.Context
import androidx.room.Room
import com.shantanubindhani.expensetracker.data.local.TransactionDao
import com.shantanubindhani.expensetracker.data.local.TransactionDatabase
import com.shantanubindhani.expensetracker.data.repository.DatastoreRepositoryImpl
import com.shantanubindhani.expensetracker.data.repository.TransactionRepositoryImpl
import com.shantanubindhani.expensetracker.domain.repository.DatastoreRepository
import com.shantanubindhani.expensetracker.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ExpenseModule {

    @Provides
    @Singleton
    fun provideDatastoreRepository(@ApplicationContext context: Context) : DatastoreRepository {
        return DatastoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideExpenseRepository(transactionDao: TransactionDao) : TransactionRepository
            = TransactionRepositoryImpl(transactionDao)

    @Provides
    @Singleton
    fun provideExpenseDatabase(@ApplicationContext context: Context) : TransactionDatabase {
        return Room.databaseBuilder(context, TransactionDatabase::class.java, "transactionDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideExpenseDao(database: TransactionDatabase) = database.transactionDao
}