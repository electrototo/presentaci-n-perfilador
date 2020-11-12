package com.smt.profilernumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var numberRV: RecyclerView
    private lateinit var model: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(this).get(NumberViewModel::class.java)

        numberRV = findViewById(R.id.numberRecyclerView)
        numberRV.layoutManager = LinearLayoutManager(this)
        numberRV.adapter = NumberAdapter(model)
    }

    fun onSort(view: View) {
        model.sort()
        numberRV.adapter!!.notifyDataSetChanged()
    }

    inner class NumberAdapter(private val dataSet: NumberViewModel) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {
        inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                textView = view.findViewById(R.id.textView)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.number_layout, parent, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = dataSet.numbers[position].toString()
        }

        override fun getItemCount() = dataSet.numbers.size
    }
}