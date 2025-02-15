package com.example.xmlnavapp2

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlnavapp2.databinding.ActivityBactivityBinding
import com.example.xmlnavapp2.databinding.ActivityMainBinding

class BActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBactivityBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val msg = intent.getStringExtra("key")
        val parceizedUser = intent.getParcelableExtra("USER_KEY", User::class.java)

        val parceizedMsg = "${parceizedUser?.name} + ${parceizedUser?.age.toString()}"
        binding.tvActivityB.text = parceizedMsg
    }
}