package com.example.hikingfitnessapplication.adapters

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hikingfitnessapplication.R
import com.example.hikingfitnessapplication.database.Run
import com.example.hikingfitnessapplication.other.TrackingUtility
import kotlinx.android.synthetic.main.item_run.view.*
import java.util.*

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>(){
    inner class RunViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    val diffCallBack = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_run,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(run.img).into(ivRunImage)

            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }
            val dateFormat = SimpleDateFormat("MM.dd.yy", Locale.getDefault())
            tvDate.text = dateFormat.format(calendar.time)

            val avgSpeed = "${run.avgspeed}miles/hr"
            tvAvgSpeed.text = avgSpeed

            val distance = "${run.distance}"
            tvDistance.text = distance

            tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.time)

            val caloriesBurned = "${run.calories}kcal"
            tvCalories.text = caloriesBurned
        }
    }
}