package com.example.arithmetic_hw2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1: EditText = findViewById(R.id.editText1)
        val text2: EditText = findViewById(R.id.editText2)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val res: TextView = findViewById(R.id.output)
        val btn: Button = findViewById(R.id.button)

        btn.setOnClickListener {
            val firstNum = text1.text.toString().toDoubleOrNull() ?: 0.0
            val secondNum = text2.text.toString().toDoubleOrNull() ?: 0.0
            var result = 0.0

            when (radioGroup.checkedRadioButtonId) {
                R.id.addition -> result = firstNum + secondNum
                R.id.subtraction -> result = firstNum - secondNum
                R.id.multiplication -> result = firstNum * secondNum
                R.id.division -> {
                    if (secondNum != 0.0) {
                        result = firstNum / secondNum
                    } else {
                        res.text = "Divide by Zero not Allowed!"
                        return@setOnClickListener
                    }
                }
                R.id.modulus -> {
                    if (secondNum != 0.0) {
                        result = firstNum % secondNum
                    } else {
                        res.text = "Compute modulus with Zero is not Allowed!"
                        return@setOnClickListener
                    }
                }
            }
            res.text = result.toString()
        }
    }
}