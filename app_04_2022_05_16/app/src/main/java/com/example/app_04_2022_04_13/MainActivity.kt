package com.example.app_04_2022_04_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.exemple.myapplication.ProdutoAdapter
import com.exemple.myapplication.com.example.app_04_2022_04_13.produtosGlobal
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

import java.util.*

import	java.text.NumberFormat
import	java.util.Locale


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val produtosAdapter = ProdutoAdapter(this)
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)


        listViewProduto.adapter = produtosAdapter

        btnAdicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }



        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
    override fun onResume()  {
        super.onResume()

        val adapter = listViewProdutos.adapter as ProdutoAdapter

        adapter.clear()
        adapter.addAll(produtosGlobal)

        var soma = 0.0

        for(item in produtosGlobal){
            soma += item.valor * item.quantidade
        }
        val f = NumberFormat.getCurrencyInstance(Locale("pt", "b"))
        txtTotal.text = "Total: ${f.format(soma)}"
    }
}
