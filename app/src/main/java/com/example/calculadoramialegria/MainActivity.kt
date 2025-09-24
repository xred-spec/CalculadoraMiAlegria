package com.example.calculadoramialegria

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

// 1-2*0 = -0 ✓
// division /0 ✓
// cambio de signo ✓
// guardar valores i guess ✓
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textResultado = findViewById<TextView>(R.id.text_resultado)

        val buttonRedo = findViewById<Button>(R.id.button_redo)
        val buttonClean = findViewById<Button>(R.id.button_clean)

        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)

        val buttonDot = findViewById<Button>(R.id.button_dot)

        val buttonSum = findViewById<Button>(R.id.button_sum)
        val buttonRes = findViewById<Button>(R.id.button_res)
        val buttonMul = findViewById<Button>(R.id.button_mul)
        val buttonDiv = findViewById<Button>(R.id.button_div)

        val buttonEq = findViewById<Button>(R.id.button_eq)

        var operacion = ""
        var num1 = 0.0
        var num2 = 0.0

        buttonRedo.setOnClickListener {
            borrarChar(textResultado)
        }

        buttonClean.setOnClickListener {
            limpiarTexto(textResultado)
        }

        button0.setOnClickListener {
            agregarNumero(textResultado, 0)
        }

        button1.setOnClickListener {
            agregarNumero(textResultado, 1)
        }

        button2.setOnClickListener {
            agregarNumero(textResultado, 2)
        }

        button3.setOnClickListener {
            agregarNumero(textResultado, 3)
        }

        button4.setOnClickListener {
            agregarNumero(textResultado, 4)
        }

        button5.setOnClickListener {
            agregarNumero(textResultado, 5)
        }

        button6.setOnClickListener {
            agregarNumero(textResultado, 6)
        }

        button7.setOnClickListener {
            agregarNumero(textResultado, 7)
        }

        button8.setOnClickListener {
            agregarNumero(textResultado, 8)
        }

        button9.setOnClickListener {
            agregarNumero(textResultado, 9)
        }

        buttonDot.setOnClickListener {
            agregarPunto(textResultado)
        }

        buttonSum.setOnClickListener {
            if(operacion == "") {
                operacion = "sum"
                num1 = textResultado.text.toString().toDouble()
                limpiarTexto(textResultado)
            } else {
                operacion = "sum"
                limpiarTexto(textResultado)
            }
        }

        buttonRes.setOnClickListener {
            if(operacion == "") {
                operacion = "res"
                num1 = textResultado.text.toString().toDouble()
                limpiarTexto(textResultado)
            } else {
                operacion = "res"
                limpiarTexto(textResultado)
            }
        }

        buttonMul.setOnClickListener {
            if(operacion == "") {
                operacion = "mul"
                num1 = textResultado.text.toString().toDouble()
                limpiarTexto(textResultado)
            } else {
                operacion = "mul"
                limpiarTexto(textResultado)
            }
        }

        buttonDiv.setOnClickListener {
            if(operacion == "") {
                operacion = "div"
                num1 = textResultado.text.toString().toDouble()
                limpiarTexto(textResultado)
            } else {
                operacion = "div"
                limpiarTexto(textResultado)
            }
        }
        buttonEq.setOnClickListener {
            num2 = textResultado.text.toString().toDouble()
            operacion = calcular(textResultado, num1, num2, operacion)
        }
    }

    fun limpiarTexto(textResultado: TextView) {
        textResultado.text = "0"
    }

    fun borrarChar(textResultado: TextView) {
        var stringTextResultado = textResultado.text.toString()
        stringTextResultado = stringTextResultado.dropLast(1)
        if(stringTextResultado.isEmpty()) stringTextResultado = "0"
        textResultado.text = stringTextResultado
    }

    fun agregarNumero(textResultado: TextView, numero: Int) {
        var stringTextResultado = textResultado.text.toString()
        if(stringTextResultado == "0") {
            if(numero != 0) stringTextResultado = numero.toString()
        } else {
            stringTextResultado += numero.toString()
        }
        textResultado.text = stringTextResultado
    }

    fun agregarPunto(textResultado: TextView) {
        var stringTextResultado = textResultado.text.toString()
        if(!stringTextResultado.contains(".")) stringTextResultado += "."
        textResultado.text = stringTextResultado
    }

    fun calcular(textResultado: TextView, num1: Double, num2: Double, operacion: String): String {
        if(operacion != "") {
            var resultado = 0.0
            when(operacion) {
                "sum" -> {
                    resultado = num1 + num2
                }
                "res" -> {
                    resultado = num1 - num2
                }
                "mul" -> {
                    resultado = num1 * num2
                }
                "div" -> {
                    if(num2 != 0.0) {
                        resultado = num1 / num2
                    }
                }
            }
            textResultado.text = resultado.toString()
            if(textResultado.text == "-0.0") textResultado.text = "0.0"
        }
        return ""
    }
}