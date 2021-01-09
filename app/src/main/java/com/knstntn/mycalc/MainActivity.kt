package com.knstntn.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

enum class Operation (
    var label: String,
    var calc: (Double, Double) -> Double
        ) {
    PLUS("+", Double::plus),
    MINUS("-", Double::minus),
    MULTIPLE("x", Double::times),
    DIVIDE("/", Double::div),
    POW("e^x", Math::pow)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operation: Operation? = null
        var number: Double? = null

        val txView = findViewById<TextView>(R.id.textView)
        val editTxt = findViewById<TextView>(R.id.editTextNumberDecimal)
        val plus = findViewById<TextView>(R.id.buttonPlus)
        val minus = findViewById<TextView>(R.id.buttonMinus)
        val mult = findViewById<TextView>(R.id.buttonMult)
        val div = findViewById<TextView>(R.id.buttonDiv)
        val clean = findViewById<TextView>(R.id.buttonClean)
        val equals = findViewById<TextView>(R.id.buttonEquals)
        val pow = findViewById<TextView>(R.id.buttonPow)
        val sqrt = findViewById<TextView>(R.id.buttonSqrt)


        val function = View.OnClickListener { view ->
            var nexnumber = textView.text.toString().toDoubleOrNull() ?: return@OnClickListener
            val nexoperation = when (view.id) {
                R.id.buttonPlus -> Operation.PLUS
                R.id.buttonMinus -> Operation.MINUS
                R.id.buttonMult -> Operation.MULTIPLE
                R.id.buttonDiv -> Operation.DIVIDE
                R.id.buttonPow -> Operation.POW

                else -> null
            } ?: return@OnClickListener
            if (txView.text != "") {
                nexnumber = operation?.calc?.invoke(number!!, nexnumber) ?: 0.0
            }
            editTxt.text = ""
            number = nexnumber
            operation = nexoperation
            txView.text = "$nexnumber ${nexoperation.label}"
        }

        plus.setOnClickListener(function)
        minus.setOnClickListener(function)
        mult.setOnClickListener(function)
        div.setOnClickListener(function)
        pow.setOnClickListener(function)

        sqrt.setOnClickListener{
            var nexnumber = textView.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            val nexoperation = Math.sqrt(nexnumber)
            editTxt.text = ""
            number = nexnumber
            operation = nexoperation
            txView.text = "√$nexnumber"
        }

        clean.setOnClickListener{
            txView.text = ""
            editTxt.text = ""
            number = null
            operation = null
        }

        equals.setOnClickListener {
            val secnumber = editTxt.text.toString().toDoubleOrNull() ?: return@setOnClickListener

            number = operation!!.calc(number!!, secnumber)
            txView.text = "$number"
            editTxt.text = ""

        }

    }
}