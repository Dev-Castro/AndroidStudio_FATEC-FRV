package com.example.app_04_2022_04_13

import android.graphics.Bitmap

data class Produto(val nome: String, val quantidade: Int, val valor: Double, val foto: Bitmap? = null)