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
    @ColumnInfo(name = "backdropPath")
    val backdropPath: String,
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Long,
    @NonNull
    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String,
    @NonNull
    @ColumnInfo(name = "originalTitle")
    val originalTitle: String,
    @NonNull
    @ColumnInfo(name = "overview")
    val overview: String,
    @NonNull
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @NonNull
    @ColumnInfo(name = "posterPath")
    val posterPath: String,
    @NonNull
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,
    @NonNull
    @ColumnInfo(name = "video")
    val video: Boolean,
    @NonNull
    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,
    @NonNull
    @ColumnInfo(name = "voteCount")
    val voteCount: Long
)

