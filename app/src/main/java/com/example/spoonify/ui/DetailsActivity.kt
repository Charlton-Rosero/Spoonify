package com.example.spoonify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.spoonify.R
import dagger.hilt.android.AndroidEntryPoint
import kotlin.coroutines.Continuation

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_acivity)

        setSupportActionBar(toolbar)
        toolbar.setTitle.TextColo(ContextCompat.getColor(this, R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}