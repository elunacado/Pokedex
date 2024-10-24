package com.example.kotlin.mypokedexapp.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.mypokedexapp.framework.views.fragments.PokedexFragment
import com.example.kotlin.mypokedexapp.framework.views.fragments.SearchFragment
import com.example.mypokedexapp.R
import com.example.mypokedexapp.databinding.ActivityMainBinding
import com.example.mypokedexapp.utils.Constants

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment
    private var currentMenuOption:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)

    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeListeners(){
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_POKEDEX)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)
        }
    }

    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
        currentFragment = newFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment)
            .commit()
        currentMenuOption = newMenuOption
    }

    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }

        when(menuOption){
            Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(),Constants.MENU_POKEDEX)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(),Constants.MENU_SEARCH)
        }
    }



    private fun initializeObservers(){

    }
}