package com.shantanubindhani.expensetracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shantanubindhani.expensetracker.data.local.converter.DateConverter
import com.shantanubindhani.expensetracker.data.local.entity.TransactionDto
import com.shantanubindhani.expensetracker.data.local.entity.AccountDto

@TypeConverters(value = [DateConverter::class])
@Database(entities = [TransactionDto::class, AccountDto::class], exportSchema = true, version = 1)
abstract class TransactionDatabase: RoomDatabase() {
    abstract val transactionDao: TransactionDao
}