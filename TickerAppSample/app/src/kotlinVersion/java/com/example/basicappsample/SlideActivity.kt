package com.example.basicappsample

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.basicappsample.databinding.ActivitySlideBinding

class SlideActivity : AppCompatActivity(), ITickerCustomFont {
    private lateinit var binding: ActivitySlideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.ticker.text = "$" + progress.toFloat() / 100
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Typefaceの設定
        setTypeFaceForTickerView(
            binding.root,
            ResourcesCompat.getFont(this, R.font.hachimaru)
        )
    }
}