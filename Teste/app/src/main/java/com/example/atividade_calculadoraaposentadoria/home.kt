package com.example.atividade_calculadoraaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val planeta = findViewById<ImageView>(R.id.img_planeta)
        val barra = findViewById<ImageView>(R.id.img_barra)
        val hello = findViewById<ImageView>(R.id.img_hello)
        val btn_neon = findViewById<ImageView>(R.id.btn_neon)
        var flag = false

        btn_neon.setOnClickListener{

            if(flag){
                planeta.setImageResource(R.drawable.planeta)
                barra.setImageResource(R.drawable.barra)
                hello.setImageResource(R.drawable.hello_world2)
                btn_neon.setImageResource(R.drawable.button)

                flag = false
            }else{
                planeta.setImageResource(R.drawable.neon)
                barra.setImageResource(R.drawable.barra_neon)
                hello.setImageResource(R.drawable.hello_world_neon)
                btn_neon.setImageResource(R.drawable.btn_neon)

                flag = true
            }

        }
    }
}