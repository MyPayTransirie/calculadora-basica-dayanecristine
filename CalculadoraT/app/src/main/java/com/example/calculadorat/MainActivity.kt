package com.example.calculadorat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEqual.setOnClickListener {
            if (resultado.text.toString() == ""){ Toast.makeText(this, "Insira uma expressão!", Toast.LENGTH_SHORT)
                .show()
            }else{
                resultado.setText(eval(resultado.text.toString()).toString())
            }
        }
        btnAC.setOnClickListener{
            resultado.setText("")
        }
    }
    fun numInclude(view: View){
        var btnClick = resultado.text.toString()
        var btnSelect = view as Button
        when(btnSelect.id){
            btn0.id -> {btnClick+="0"}
            btn1.id -> {btnClick+="1"}
            btn2.id -> {btnClick+="2"}
            btn3.id -> {btnClick+="3"}
            btn4.id -> {btnClick+="4"}
            btn5.id -> {btnClick+="5"}
            btn6.id -> {btnClick+="6"}
            btn7.id -> {btnClick+="7"}
            btn8.id -> {btnClick+="8"}
            btn9.id -> {btnClick+="9"}
            btnSoma.id -> {btnClick+="+"}
            btnSub.id -> {btnClick+="-"}
            btnMult.id -> {btnClick+="*"}
            btnDiv.id -> {btnClick+="/"}
            btnOpnParentesis.id -> {btnClick+="("}
            btnCloseParentesis.id -> {btnClick+=")"}
        }
        resultado.setText(btnClick)
    }
    fun eval(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0
            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length){
                    Toast.makeText(this@MainActivity,"Erro.",Toast.LENGTH_SHORT).show()
                    throw RuntimeException("Inesperado: " + ch.toChar())}
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm() // addition
                    else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor() // multiplication
                    else if (eat('/'.toInt())) x /= parseFactor() // division
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor() // unary plus
                if (eat('-'.toInt())) return -parseFactor() // unary minus
                var x: Double
                val startPos = pos
                if (eat('('.toInt())) { // parentheses
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt()) { // numbers
                    while (ch >= '0'.toInt() && ch <= '9'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                }  else {
                    Toast.makeText(this@MainActivity,"Erro.",Toast.LENGTH_SHORT).show()
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                return x
            }
        }.parse()
    }
}

