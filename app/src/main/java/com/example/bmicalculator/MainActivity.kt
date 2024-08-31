package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculatebtn.setOnClickListener {
            val height = binding.height.text.toString()
            val weight = binding.weight.text.toString()
            if (height.isEmpty() || weight.isEmpty()) {
                binding.result.text = "Please enter both height and weight"
                binding.main.setBackgroundResource(R.drawable.mainbg)
                return@setOnClickListener
            }


            else{
                val heightInput:Float = height.toFloat()/100
                val weightInput:Float = weight.toFloat()
                when(val bmi:Float = weightInput/(heightInput*heightInput)){
                    in 1.00..18.4-> binding.result.text = String.format("Your BMI is: %.2f and you are underweight",bmi)
                    in 18.5..25.5-> binding.result.text = String.format("Your BMI is %.2f and you have perfect weight",bmi)
                    in 25.6..30.5-> binding.result.text = String.format("Your BMI is %.2f and you are overweight",bmi)
                    in 30.6..40.5-> binding.result.text = String.format("Your BMI is %.2f and you are obesity",bmi)
                    else -> binding.result.text = String.format("Your BMI is %.2f. Are you eat like an Elephant",bmi)
                }
                binding.main.setBackgroundResource(R.drawable.mainbg2)
            }

        }
        binding.reset.setOnClickListener {

            binding.height.text.clear()
            binding.weight.text.clear()

            binding.result.text = null

            binding.main.setBackgroundResource(R.drawable.mainbg)
        }

    }
}