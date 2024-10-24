package com.example.mypokedexapp.data.network

import com.example.mypokedexapp.data.network.model.PokedexObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPIService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int
    ): com.example.mypokedexapp.data.network.model.PokedexObject

    //https://pokeapi.co/api/v2/pokemon/{number_pokemon}/
    @GET("pokemon/{numberPokemon}")
    suspend fun getPokemonInfo(
        @Path("numberPokemon") numberPokemon:Int
    ) : com.example.mypokedexapp.data.network.model.pokemon.pokemon
}