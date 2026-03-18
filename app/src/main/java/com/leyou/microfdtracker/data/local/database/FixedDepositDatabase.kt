package com.leyou.microfdtracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leyou.microfdtracker.data.local.converter.Converters
import com.leyou.microfdtracker.data.local.dao.FixedDepositDao
import com.leyou.microfdtracker.data.local.entity.FixedDepositEntity

@Database(entities = [FixedDepositEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class FixedDepositDatabase : RoomDatabase() {

    abstract val fixedDepositDao: FixedDepositDao

//    companion object {
//        @Volatile
//        private var INSTANCE: FixedDepositDatabase? = null
//
//        fun getDatabase(context: Context): FixedDepositDatabase {
//            if (INSTANCE == null) {
//                synchronized(this) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        FixedDepositDatabase::class.java,
//                        "fdDB"
//                    ).build()
//                }
//            }
//            return INSTANCE!!
//        }
//
//    }
}