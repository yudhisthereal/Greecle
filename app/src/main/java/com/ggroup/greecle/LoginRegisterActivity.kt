package com.ggroup.greecle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login_register)
    }
}