package com.example.espressoappformentoring;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.espressoappformentoring.databinding.ActivitySecondBinding;

public class SecondActivity : AppCompatActivity()  {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
