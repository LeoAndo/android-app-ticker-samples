package com.example.basicappsample;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.basicappsample.databinding.ActivitySlideBinding;

public class SlideActivity extends AppCompatActivity implements ITickerCustomFont {

    private ActivitySlideBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySlideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.ticker.setText("$" + (float) progress / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Typefaceの設定
        setTypeFaceForTickerView(
                binding.getRoot(),
                ResourcesCompat.getFont(this, R.font.hachimaru)
        );
    }
}
