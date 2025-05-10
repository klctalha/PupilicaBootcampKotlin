package com.talhakilic.kasimhocaodev


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.talhakilic.kasimhocaodev.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var clickValue: String = ""
    private var lastResult: String = ""
    private var resultDisplay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {

            btn0?.setOnClickListener { appendClickValue("0") }
            btn1?.setOnClickListener { appendClickValue("1") }
            btn2?.setOnClickListener { appendClickValue("2") }
            btn3?.setOnClickListener { appendClickValue("3") }
            btn4?.setOnClickListener { appendClickValue("4") }
            btn5?.setOnClickListener { appendClickValue("5") }
            btn6?.setOnClickListener { appendClickValue("6") }
            btn7?.setOnClickListener { appendClickValue("7") }
            btn8?.setOnClickListener { appendClickValue("8") }
            btn9?.setOnClickListener { appendClickValue("9") }
            btnPlus?.setOnClickListener { appendClickValue("+") }
            btnSubtract?.setOnClickListener { appendClickValue("-") }
            btnMultiply?.setOnClickListener { appendClickValue("*") }
            btnDivide?.setOnClickListener { appendClickValue("/") }
            btnBrackets?.setOnClickListener { appendClickValue("(") }
            btnBrackets?.setOnLongClickListener {
                appendClickValue(")")
                true
            }
            btnDot?.setOnClickListener { appendClickValue(".") }
            btnRemainder?.setOnClickListener { appendClickValue("%") }
        }
    }

    private fun appendClickValue(value: String) {
        if (resultDisplay && value in listOf("+", "-", "*", "/", "%")) {
            clickValue = lastResult + value
        } else if (resultDisplay) {
            clickValue = value
        } else {
            clickValue += value
        }
        resultDisplay = false
        binding.showActionView?.text = clickValue
    }

    fun del(view: View) {
        if (clickValue.isNotEmpty()) {
            clickValue = clickValue.substring(0,clickValue.length-1)
            binding.showActionView?.text = clickValue
        }
    }

    fun cleanAll(view: View) {
        clickValue = ""
        lastResult = ""
        binding.showActionView?.text = clickValue
        binding.resultView?.text = ""
    }

    fun equals(view: View) {
        try {
            val expressionText = clickValue ?: ""
            if (expressionText.isBlank()) {
                Toast.makeText(view.context, "Enter a valid expression.", Toast.LENGTH_SHORT).show()
                return
            }
            val expression = ExpressionBuilder(expressionText).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            binding.resultView?.text = if (result == longResult.toDouble()) {
                longResult.toString()
            } else {
                result.toString()
            }
            lastResult = binding.resultView?.text.toString()
            resultDisplay = true
        } catch (e: Exception) {
            Log.e("EvaluationError", "Error evaluating expression: ${e.message}")
            binding.resultView?.text="Error"
        }

    }
}