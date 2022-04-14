package com.example.atividade_aposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino","Feminino"))

        //btn_Calcular_onclick
        btn_Calcular.setOnClickListener{
            val sexo = spn_Sexo.selectedItem as String
            var resultado = 0.0
            val limite = if (sexo == "Masculino") 65.0 else 61.5

            try {
                val idade = txt_Idade.text.toString().replace(" ", "").toInt()

                if(idade.toString()!="") {

                    if(idade>0) {

                        if(idade<limite) {

                            resultado = limite - idade
                            var printResultado = if (resultado % 1 > 0) {
                                "${resultado.toInt()} ano(s) e ${(resultado % 1 * 12).toInt()} mes(es)"
                            } else {
                                resultado.toInt().toString()
                            }
                            txt_Resultado.text = "Faltam $printResultado para você se aposentar"
                        } else {txt_Resultado.text = "Você já tem idade para se aposentar"}
                    } else {txt_Idade.error = "Sua idade não pode ser negativa!"}
                } else {txt_Idade.error = "Digite a sua idade..."}

            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> txt_Idade.error =
                        "Valor inválido, tente novamente..."
                    is IndexOutOfBoundsException -> txt_Idade.error =
                        "Valor inválido, tente novamente..."
                }
            }

        }

    }

}