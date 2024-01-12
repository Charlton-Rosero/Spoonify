package com.example.spoonify.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import com.example.spoonify.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2700)
    }

    private fun initTimer() = lifecycleScope.launch {
        delay(DELAY_ANIMATION)
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }

    companion object {
        const val DELAY_ANIMATION = 2000L
    }
}