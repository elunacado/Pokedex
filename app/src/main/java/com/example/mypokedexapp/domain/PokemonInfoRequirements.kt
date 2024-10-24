package com.example.kotlin.mypokedexapp.domain

import com.example.mypokedexapp.data.PokemonRepository
import com.example.mypokedexapp.data.network.model.pokemon.pokemon


class PokemonInfoRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        numberPokemon:Int
    ): pokemon? = repository.getPokemonInfo(numberPokemon)
}