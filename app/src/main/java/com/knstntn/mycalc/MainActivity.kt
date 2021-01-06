package com.knstntn.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

enum class Operation {
    PLUS, MINUS, MULTIPLE, DIVIDE
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operation: Operation? = null
        var number: Double? = null

        val txView = findViewById(R.id.textView)
        val editTxt = findViewById<TextView>(R.id.editTextNumberDecimal)
        val plus = findViewById<TextView>(R.id.buttonPlus)
        val minus = findViewById<TextView>(R.id.buttonMinus)
        val mult = findViewById<TextView>(R.id.buttonMult)
        val div = findViewById<TextView>(R.id.buttonDiv)
        val clean = findViewById<TextView>(R.id.buttonClean)
        val equals = findViewById<TextView>(R.id.buttonEquals)

        val function

        clean.setOnClickListener{
            txView = ""
            editTxt = ""
            number = null
            operation = null
        }

    }
}