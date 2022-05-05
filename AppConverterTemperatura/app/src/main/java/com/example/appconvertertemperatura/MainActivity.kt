package com.example.appconvertertemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_De = findViewById<Spinner>(R.id.spn_De)
        val spn_Para = findViewById<Spinner>(R.id.spn_Para)
        val entrada = findViewById<EditText>(R.id.ctx_Entrada)
        val converter = findViewById<Button>(R.id.btn_Converter)
        val resultado = findViewById<TextView>(R.id.txt_Resultado)

        val listaDe = listOf("Celsius", "Fahrenheit", "Kelvin")
        val listaPara = listOf("Fahrenheit", "Kelvin", "Celsius")

        spn_De.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaDe)
        spn_Para.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaPara)

        converter.setOnClickListener {

            val de = spn_De.selectedItem as String
            val para = spn_Para.selectedItem as String
            var formula = 0.0

            if(entrada.text.toString()!=""){

                if(de!=para){

                    when(de){

                        "Celsius" -> when(para){

                            "Fahrenheit" -> {
                                resultado.text = "C-F"

                                val c = entrada.text.toString().toDouble()
                                formula = ((9.0*c + 160.0)/5.0)
                                resultado.text="O valor ${entrada.text}°(Celsius) em Fahrenheit é: %.1f°F".format(formula)

                            }

                            else -> {
                                resultado.text = "C-K"

                                val c = entrada.text.toString().toDouble()
                                formula = c + 273
                                resultado.text="O valor ${entrada.text}°(Celsius) em Kelvin é: %.1fK".format(formula)

                            }

                        }
                        "Fahrenheit" -> when(para){

                            "Kelvin" -> {
                                resultado.text = "F-K"

                                val f = entrada.text.toString().toDouble()
                                formula = ((f - 32.0)*(5.0/9.0)) + 273
                                resultado.text="O valor ${entrada.text}°(Fahrenheit) em Kelvin é: %.1fK".format(formula)

                            }

                            else -> {
                                resultado.text = "F-C"

                                val f = entrada.text.toString().toDouble()
                                formula = ((f - 32.0)*(5.0/9.0))
                                resultado.text="O valor ${entrada.text}°(Fahrenheit) em Celsius é: %.1f°C".format(formula)

                            }

                        }
                        else -> when(para){

                            "Celsius" -> {
                                resultado.text = "K-C"

                                val k = entrada.text.toString().toDouble()
                                formula = k - 273
                                resultado.text="O valor ${entrada.text}K(Kelvin) em Celsius é: %.1f°C".format(formula)

                            }

                            else -> {
                                resultado.text = "K-F"

                                val k = entrada.text.toString().toDouble()
                                formula = ((9.0*(k-273) + 160.0)/5.0)
                                resultado.text="O valor ${entrada.text}K(Kelvin) em Fahrenheit é: %.1f°F".format(formula)

                            }

                        }
                    }

                }else entrada.error = "Você não pode Converter para a mesma temperatura!"
            }else entrada.error = "Digite a temperatura!"
        }

    }


}