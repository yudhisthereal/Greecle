package com.ggroup.greecle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ggroup.greecle.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
//        setContentView(R.layout.activity_main)
    }
}