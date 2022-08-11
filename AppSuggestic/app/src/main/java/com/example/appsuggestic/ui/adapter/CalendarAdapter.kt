package com.example.appsuggestic.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appsuggestic.domain.Calendar
import com.example.appsuggestic.R

class CalendarAdapter (var calendar: ArrayList<Calendar>, val onActionsListener: OnActionsListener?)
    : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(calendar.get(position))
    }
    override fun getItemCount(): Int {
        return calendar!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNumber = itemView.findViewById<TextView>(R.id.txtNumber)
        val txtDay = itemView.findViewById<TextView>(R.id.txtDay)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val txtSubtitle = itemView.findViewById<TextView>(R.id.txtSubtitle)
        val clClickItem = itemView.findViewById<ConstraintLayout>(R.id.clClickItem)
        fun bind(calendar: Calendar) {
            txtNumber.text = calendar.day
            txtDay.text = calendar.textDay
            txtTitle.text = calendar.title
            txtSubtitle.text = calendar.subtitle
            clClickItem.setOnClickListener {
                onActionsListener?.onOrderSelected(calendar)
            }
        }
    }

    interface OnActionsListener {
        fun onOrderSelected(calendar: Calendar?)
    }
}