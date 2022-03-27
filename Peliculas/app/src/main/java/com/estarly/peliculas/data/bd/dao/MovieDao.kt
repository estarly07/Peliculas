package com.estarly.peliculas.data.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.estarly.peliculas.domain.entities.MovieEntity

@Dao
interface MovieDao {
    @Insert
    suspend fun registerMovie(movie: MovieEntity): Long

    @Query("DELETE FROM Movie WHERE id =:idMovie; ")
    suspend fun deleteMovie(idMovie: Long)

    @Query("SELECT * FROM Movie")
    suspend fun getMoviesFavorites(): List<MovieEntity>
    @Query("SELECT * FROM Movie WHERE id =:idMovie")
    fun getMovie(idMovie: Long): MovieEntity?
}