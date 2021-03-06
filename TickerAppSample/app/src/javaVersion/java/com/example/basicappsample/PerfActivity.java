package com.example.basicappsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robinhood.ticker.TickerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PerfActivity extends BaseActivity {
    private final List<TickerViewHolder> boundViewHolders = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perf);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new TestAdapter());
    }

    @Override
    protected void onUpdate() {
        for (TickerViewHolder viewHolder : boundViewHolders) {
            viewHolder.update(true);
        }
    }

    private class TestAdapter extends RecyclerView.Adapter<TickerViewHolder> {
        private LayoutInflater inflater;

        @NonNull
        @Override
        public TickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.getContext());
            }

            return new TickerViewHolder(inflater.inflate(R.layout.row_perf, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull TickerViewHolder holder, int position) {
            boundViewHolders.add(holder);
            holder.update(false);
        }

        @Override
        public int getItemCount() {
            return 1000;
        }
    }

    private class TickerViewHolder extends RecyclerView.ViewHolder {
        private final TickerView ticker1;
        private final TickerView ticker2;
        private final TickerView ticker3;
        private final TickerView ticker4;

        TickerViewHolder(View itemView) {
            super(itemView);
            ticker1 = itemView.findViewById(R.id.ticker1);
            ticker2 = itemView.findViewById(R.id.ticker2);
            ticker3 = itemView.findViewById(R.id.ticker3);
            ticker4 = itemView.findViewById(R.id.ticker4);
        }

        void update(boolean animate) {
            ticker1.setText(getRandomNumber(8), animate);
            ticker2.setText(getRandomNumber(8), animate);
            ticker3.setText(getRandomNumber(8), animate);
            ticker4.setText(getRandomNumber(8), animate);
        }
    }
}