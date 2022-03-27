package com.estarly.peliculas.data.bd.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.estarly.peliculas.data.bd.dao.MovieDao
import com.estarly.peliculas.domain.entities.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ],
    version = 1
)
abstract class SqliteDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: SqliteDb? = null

        fun getInstance(context: Context): SqliteDb {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    SqliteDb::class.java,
                    "Movie"
                ).allowMainThreadQueries().build()
                return INSTANCE!!
            }
        }
    }
}