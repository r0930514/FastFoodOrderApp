package com.r0930514.fastfoodorderapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CartEntity::class],
    version = 1,
    views = [CartOrderView::class]
)
abstract class CartDatabase: RoomDatabase() {
    abstract fun cartDao(): CartDao
    companion object{
        @Volatile
        private var INSTANCE: CartDatabase? = null

        fun getDatabase(context: Context): CartDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CartDatabase::class.java,
                    "cart_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}