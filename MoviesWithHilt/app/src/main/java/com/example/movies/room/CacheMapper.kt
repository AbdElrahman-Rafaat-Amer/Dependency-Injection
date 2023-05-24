package com.example.movies.room

import com.example.movies.models.Movie
import com.example.movies.utils.EntityMapper
import javax.inject.Inject


class CacheMapper @Inject constructor() : EntityMapper<MovieCashEntity, Movie> {
    override fun mapFromEntity(entity: MovieCashEntity): Movie {
        return Movie(
            crew = entity.crew,
            rate = entity.rate,
            title = entity.title,
            image = entity.image,
            year = entity.year,
            rank = entity.rank
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieCashEntity {
        return MovieCashEntity(
            crew = domainModel.crew,
            rate = domainModel.rate,
            title = domainModel.title,
            image = domainModel.image,
            year = domainModel.year,
            rank = domainModel.rank,
        )
    }

    fun mapFromEntityList(entities: List<MovieCashEntity>): List<Movie>{
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(movies: List<Movie>): List<MovieCashEntity>{
        return movies.map { mapToEntity(it) }
    }
}

