package com.example.mypokedexapp.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.mypokedexapp.framework.viewmodel.SplashScreenViewModel
import com.example.kotlin.mypokedexapp.framework.views.activities.MainActivity
import com.example.mypokedexapp.databinding.ActivitySplashscreenBinding

class SplashScreenActivity:AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()

        viewModel.onCreate()

        initializeObservers()
    }

    private fun initializeBinding(){
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.finishedLoading.observe(this, Observer {finishedLoading->
            if(finishedLoading){
                passViewGoToMain()
            }
        })
    }

    private fun passViewGoToMain() {
        var intent: Intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}