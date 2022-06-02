package com.example.app_05_2022_05_25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URL
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.channels.ticker
import org.json.JSONObject
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val API_URL = "https://viacep.com.br/ws/"

    var estado: String = ""
    var cidade: String = ""
    var bairro: String = ""
    var rua: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProcurar = findViewById<Button>(R.id.btnProcurar)

        val ctxCep = findViewById<EditText>(R.id.ctxCep)

        ctxCep.requestFocus()
        btnProcurar.setOnClickListener {
            buscaCep(API_URL+"${ctxCep.text}/json")
        }
    }
    fun buscaCep(url: String){

        GlobalScope.async (Dispatchers.Default) {

            val resposta = URL(url).readText()

            estado = JSONObject(resposta).getString("uf")
            cidade = JSONObject(resposta).getString("localidade")
            bairro = JSONObject(resposta).getString("bairro")
            rua = JSONObject(resposta).getString("logradouro")

            val txtEstado = findViewById<TextView>(R.id.txtEstado)
            val txtCidade = findViewById<TextView>(R.id.txtCidade)
            val txtBairro = findViewById<TextView>(R.id.txtBairro)
            val txtRua = findViewById<TextView>(R.id.txtRua)

            txtCidade.setText(cidade)
            txtEstado.setText(estado)
            txtBairro.setText(bairro)
            txtRua.setText(rua)

            withContext(Main){

            }
        }
    }
}