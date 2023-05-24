package com.example.movies.network

import com.example.movies.models.Movie
import com.example.movies.utils.EntityMapper
import javax.inject.Inject


class NetworkMapper @Inject constructor() : EntityMapper<MovieNetworkModel, Movie> {
    override fun mapFromEntity(entity: MovieNetworkModel): Movie {
        return Movie(
            crew = entity.crew,
            rate = entity.imDbRating,
            title = entity.title,
            image = entity.image,
            year = entity.year,
            rank = entity.rank
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieNetworkModel {
        return MovieNetworkModel(
            crew = domainModel.crew,
            imDbRating = domainModel.rate,
            title = domainModel.title,
            image = domainModel.image,
            year = domainModel.year,
            rank = domainModel.rank
        )
    }

    fun mapFromEntityList(entities: MovieResponse): List<Movie>{
        return entities.movies.map { mapFromEntity(it) }
    }

}

