package com.softdevandre.bmicalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.softdevandre.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.etHeight.doAfterTextChanged { text ->
            // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.etWeight.doOnTextChanged { text, _, _, _ ->
            // binding.tvTitle.text = text
        }

        binding.btCalculate.setOnClickListener {
            calculateBMI(binding.etWeight.text.toString(), binding.etHeight.text.toString())
        }
    }

    private fun calculateBMI(weight: String, height: String){
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()
        if (weight != null && height != null) {
            val bmi = weight / (height * height)
            binding.tvTitle.text = String.format("Your BMI is:\n %.2f", bmi)
        }
    }
}