package com.estarly.peliculas.domain.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class MovieEntity(
    @NonNull
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @NonNull
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String,
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Long,
    @NonNull
    @ColumnInfo(name = "original_language")
    val original_language: String,
    @NonNull
    @ColumnInfo(name = "original_title")
    val original_title: String,
    @NonNull
    @ColumnInfo(name = "overview")
    val overview: String,
    @NonNull
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @NonNull
    @ColumnInfo(name = "poster_path")
    val poster_path: String,
    @NonNull
    @ColumnInfo(name = "release_date")
    val release_date: String,
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,
    @NonNull
    @ColumnInfo(name = "video")
    val video: Boolean,
    @NonNull
    @ColumnInfo(name = "vote_average")
    val vote_average: Double,
    @NonNull
    @ColumnInfo(name = "vote_count")
    val vote_count: Long
)

