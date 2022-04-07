package com.example.atividade_calculadoraaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object: CountDownTimer(5000, 1000){
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                setContentView(R.layout.activity_home)
            }

        }.start()

    }
}