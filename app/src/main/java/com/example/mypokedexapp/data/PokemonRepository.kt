package com.example.mypokedexapp.data

import com.example.mypokedexapp.data.network.NetworkModuleDI
import com.example.mypokedexapp.data.network.model.PokedexObject
import com.example.mypokedexapp.data.network.PokemonAPIService
import com.example.mypokedexapp.data.network.PokemonApiClient
import com.example.mypokedexapp.data.network.model.pokemon.pokemon

class PokemonRepository() {
    private val apiPokemon =PokemonApiClient()

    suspend fun getPokemonList(limit:Int): PokedexObject? =apiPokemon.getPokemonList(limit)

    suspend fun getPokemonInfo(numberPokemon:Int): pokemon? = apiPokemon.getPokemonInfo(numberPokemon)

}