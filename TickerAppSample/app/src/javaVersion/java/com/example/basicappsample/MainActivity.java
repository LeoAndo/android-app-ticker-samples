package com.example.basicappsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;

import com.example.basicappsample.databinding.ActivityMainBinding;
import com.robinhood.ticker.TickerView;

import java.util.Random;

public class MainActivity extends BaseActivity implements ITickerCustomFont {
    private final String alphabetlist = "abcdefghijklmnopqrstuvwxyz";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ticker1.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);
        binding.ticker2.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
        binding.ticker3.setPreferredScrollingDirection(TickerView.ScrollingDirection.ANY);

        binding.perfBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, PerfActivity.class))
        );

        binding.slideBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SlideActivity.class))
        );

        // Typefaceの設定
        setTypeFace(
                binding.getRoot(),
                ResourcesCompat.getFont(this, R.font.hachimaru)
        );
    }

    @Override
    protected void onUpdate() {
        final int digits = RANDOM.nextInt(2) + 6;
        binding.ticker1.setText(getRandomNumber(digits));
        final String currencyFloat = Float.toString(RANDOM.nextFloat() * 100);
        binding.ticker2.setText("$" + currencyFloat.substring(0, Math.min(digits, currencyFloat.length())));
        binding.ticker3.setText(generateChars(RANDOM, alphabetlist, digits));
    }

    private String generateChars(Random random, String list, int numDigits) {
        final char[] result = new char[numDigits];
        for (int i = 0; i < numDigits; i++) {
            result[i] = list.charAt(random.nextInt(list.length()));
        }
        return new String(result);
    }
}
