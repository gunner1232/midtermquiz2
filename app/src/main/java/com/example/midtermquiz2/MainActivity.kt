package com.example.midtermquiz2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {
    //global variable
    private var sum2Result: Double = 0.0
    private var flag: String = "Expenditure"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//Initialize references to buttons and input fields
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val edtxt3: EditText = findViewById(R.id.ednum3)
        val edtxt4: EditText = findViewById(R.id.ednum4)
        val edtxt5: EditText = findViewById(R.id.ednum5)
        val edtxt6: EditText = findViewById(R.id.ednum6)
        val edtxt7: EditText = findViewById(R.id.ednum7)
        val edtxt8: EditText = findViewById(R.id.ednum8)
        val resultTV: TextView = findViewById(R.id.result1)
        val resultTV2: TextView = findViewById(R.id.result2)
//create a spinner items
        val spinnerVal: Spinner = findViewById(R.id.spinner1)
        val options = arrayOf("Expenditure", "Total")
        spinnerVal.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


//function of button1
        button1.setOnClickListener {
            val a = edtxt1.text.toString().toDoubleOrNull()
            val b = edtxt2.text.toString().toDoubleOrNull()
            val c = edtxt3.text.toString().toDoubleOrNull()
            val d = edtxt4.text.toString().toDoubleOrNull()
            val e = edtxt5.text.toString().toDoubleOrNull()
            val f = edtxt6.text.toString().toDoubleOrNull()
            val g = edtxt7.text.toString().toDoubleOrNull()
            val h = edtxt8.text.toString().toDoubleOrNull()

            if (a == null || b == null || c == null || d == null || e == null || f == null || g == null || h == null) {
                resultTV.text = "Please enter valid numbers"
            } else {
                if (flag == "Expenditure") {
                    resultTV.text = sum1(c, d, e, f, g, h).toString()
                } else {
                    sum2Result = sum2(a, b, c, d, e, f, g, h)
                    resultTV.text = sum2Result.toString()
                }
            }
        }
//function of button2
        button2.setOnClickListener {
            resultTV2.text = if (sum2Result > 0) {
                "Good work!!!"
            } else {
                "Plan your finances more wisely."
            }
        }
    }



    //functions of sum1 and sum2
    private fun sum1(c: Double, d: Double, e: Double, f: Double, g: Double, h: Double): Double {
        return c + d + e + f + g + h
    }

    private fun sum2(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double, g: Double, h: Double): Double {
        return a + b + c + d + e + f + g + h
    }
}