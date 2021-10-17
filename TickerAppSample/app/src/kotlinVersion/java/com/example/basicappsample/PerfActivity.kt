package com.example.basicappsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.robinhood.ticker.TickerView
import java.util.*

class PerfActivity : BaseActivity() {
    private val boundViewHolders: MutableList<TickerViewHolder> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perf)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TestAdapter()
    }

    override fun onUpdate() {
        for (viewHolder in boundViewHolders) {
            viewHolder.update(true)
        }
    }

    private inner class TestAdapter : RecyclerView.Adapter<TickerViewHolder>() {
        private var inflater: LayoutInflater? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerViewHolder {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.context)
            }
            return TickerViewHolder(inflater!!.inflate(R.layout.row_perf, parent, false))
        }

        override fun onBindViewHolder(holder: TickerViewHolder, position: Int) {
            boundViewHolders.add(holder)
            holder.update(false)
        }

        override fun getItemCount(): Int {
            return 1000
        }
    }

    private inner class TickerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val ticker1: TickerView = itemView.findViewById(R.id.ticker1)
        private val ticker2: TickerView = itemView.findViewById(R.id.ticker2)
        private val ticker3: TickerView = itemView.findViewById(R.id.ticker3)
        private val ticker4: TickerView = itemView.findViewById(R.id.ticker4)
        fun update(animate: Boolean) {
            ticker1.setText(getRandomNumber(8), animate)
            ticker2.setText(getRandomNumber(8), animate)
            ticker3.setText(getRandomNumber(8), animate)
            ticker4.setText(getRandomNumber(8), animate)
        }

    }
}