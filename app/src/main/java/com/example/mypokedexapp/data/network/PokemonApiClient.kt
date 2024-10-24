package com.example.mypokedexapp.data.network

import com.example.mypokedexapp.data.network.model.pokemon.pokemon

class PokemonApiClient {
    private lateinit var api: PokemonAPIService

    suspend fun getPokemonList(limit:Int): com.example.mypokedexapp.data.network.model.PokedexObject?{
        api = NetworkModuleDI()
        return try{
            api.getPokemonList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getPokemonInfo(numberPokemon:Int): com.example.mypokedexapp.data.network.model.pokemon.pokemon?{
        api = NetworkModuleDI()
        return try{
            api.getPokemonInfo(numberPokemon)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}