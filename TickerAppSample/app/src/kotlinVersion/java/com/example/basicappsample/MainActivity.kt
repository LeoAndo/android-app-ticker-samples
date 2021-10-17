package com.example.basicappsample

import android.content.Intent
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.basicappsample.databinding.ActivityMainBinding
import com.robinhood.ticker.TickerView
import java.util.*

class MainActivity : BaseActivity(), ITickerCustomFont {
    private val alphabetlist = "abcdefghijklmnopqrstuvwxyz"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ticker1.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN)
        binding.ticker2.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP)
        binding.ticker3.setPreferredScrollingDirection(TickerView.ScrollingDirection.ANY)
        binding.perfBtn.setOnClickListener { v ->
            startActivity(
                Intent(
                    this@MainActivity,
                    com.example.basicappsample.PerfActivity::class.java
                )
            )
        }
        binding.slideBtn.setOnClickListener { v ->
            startActivity(
                Intent(
                    this@MainActivity,
                    com.example.basicappsample.SlideActivity::class.java
                )
            )
        }

        // Typefaceの設定
        setTypeFaceForTickerView(
            binding.root,
            ResourcesCompat.getFont(this, R.font.hachimaru)
        )
    }

    override fun onUpdate() {
        val digits = RANDOM.nextInt(2) + 6
        binding.ticker1.text = getRandomNumber(digits)
        val currencyFloat = (RANDOM.nextFloat() * 100).toString()
        binding.ticker2.text =
            "$" + currencyFloat.substring(0, digits.coerceAtMost(currencyFloat.length))
        binding.ticker3.text = generateChars(RANDOM, alphabetlist, digits)
    }

    private fun generateChars(random: Random, list: String, numDigits: Int): String {
        val result = CharArray(numDigits)
        for (i in 0 until numDigits) {
            result[i] = list[random.nextInt(list.length)]
        }
        return String(result)
    }
}