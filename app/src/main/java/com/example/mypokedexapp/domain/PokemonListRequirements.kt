package com.example.kotlin.mypokedexapp.domain

import com.example.mypokedexapp.data.PokemonRepository
import com.example.mypokedexapp.data.network.model.PokedexObject

class PokemonListRequirement {

    private val repository = PokemonRepository()

    suspend operator fun invoke(
        limit:Int
    ): PokedexObject? = repository.getPokemonList(limit)
}