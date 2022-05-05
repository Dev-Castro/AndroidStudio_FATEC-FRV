package com.example.applistadecompras

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<EditText>(R.id.txtProduto)
        var lista = arrayListOf<String>()

        listViewProdutos.adapter = produtosAdapter

        btnInserir.setOnClickListener {

            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
                if (!lista.contains(produto)){
                    produtosAdapter.add(produto)
                    lista.add(produto)
                    txtProduto.text.clear()
                } else txtProduto.error = "Item já está na lista"
            } else txtProduto.error = "Coloque um Produto"

        }

        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            lista.remove(item)

        }
    }
}