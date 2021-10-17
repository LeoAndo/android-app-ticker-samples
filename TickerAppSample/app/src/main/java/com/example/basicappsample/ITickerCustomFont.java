package com.example.basicappsample;

import static com.example.basicappsample.helpers.ViewUtil.getViewTree;

import android.graphics.Typeface;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.robinhood.ticker.TickerView;

import java.util.List;

public interface ITickerCustomFont {
    default void setTypeFace(@NonNull final View vg, @Nullable Typeface typeface) {
        final List<View> viewTree = getViewTree(vg);
        viewTree.stream().filter(view -> view instanceof TickerView).forEach(view -> ((TickerView) view).setTypeface(typeface));
    }
}
