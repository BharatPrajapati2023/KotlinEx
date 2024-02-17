package com.test.kotlinex.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.kotlinex.R

class RecyclerOneAdapter(context: Context, var dataList: List<OneModelItem>?) :
    RecyclerView.Adapter<RecyclerOneAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerOneAdapter.Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_data_one_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: RecyclerOneAdapter.Holder, position: Int) {
        val dataoneModel = dataList?.get(position)
        holder.uid.text = dataoneModel?.userId.toString()
        holder.id.text = dataoneModel?.id.toString()
        holder.title.text = dataoneModel?.title.toString()
        holder.body.text = dataoneModel?.body.toString()
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class Holder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val uid: TextView = itemView.findViewById<TextView>(R.id.user_id)
        val id: TextView = itemView.findViewById<TextView>(R.id.id)
        val title: TextView = itemView.findViewById<TextView>(R.id.title)
        val body: TextView = itemView.findViewById<TextView>(R.id.body)
    }
}