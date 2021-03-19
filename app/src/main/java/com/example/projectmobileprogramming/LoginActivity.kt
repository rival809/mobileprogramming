package com.example.projectmobileprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userEmail: EditText = findViewById(R.id.userEmail)
        val userPassword: EditText = findViewById(R.id.userPassword)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, DashboardActivity::class.java)
            startActivity(i)

            //TODO
            //lakukan validasi
            //jika tidak valid tampilkan toast
            //Toast.makeText(this, "Login Gagal. User tidak ditemukan", Toast.LENGTH_SHORT).show()
        })
    }
}