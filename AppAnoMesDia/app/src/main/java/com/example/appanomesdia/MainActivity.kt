package com.example.appanomesdia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_Ano = findViewById<EditText>(R.id.txt_Ano)
        val txt_Mes = findViewById<EditText>(R.id.txt_Mes)
        val txt_Dia = findViewById<EditText>(R.id.txt_Dia)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val btn_Converter = findViewById<Button>(R.id.btn_Converter)

        btn_Converter.setOnClickListener {
            if (txt_Ano.text.isEmpty()) {
                txt_Ano.error = "Digite a quantidade de ano(s)"
            } else if (txt_Mes.text.isEmpty()) {
                txt_Mes.error = "Digite a quantidade de mes(es)"
            } else if (txt_Dia.text.isEmpty()) {
                txt_Dia.error = "Digite a quantidade dia(s)"
            } else {
                val diasMeses = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

                val ano = txt_Ano.text.toString().toInt()
                var meses = txt_Mes.text.toString().toInt()
                val dias = txt_Dia.text.toString().toInt()

                var mesAtual = LocalDate.now().monthValue

                // Calcula os dias dos anos e os dias
                var idadeDias = dias + (ano*365) + (ano/4)

                // Calcula os dias dos meses
                while (meses>0){
                    if(mesAtual-1==0)mesAtual = 12 else mesAtual-=1
                    idadeDias += diasMeses[mesAtual-1]
                    meses--
                }
                txt_Resultado.text = "Você tem $idadeDias dia(s)"
            }
        }

    }
}