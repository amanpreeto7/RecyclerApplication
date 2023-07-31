package com.o7solutions.recyclerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author: 017
 * @Date: 31/07/23
 * @Time: 1:42 pm
 */

class RecyclerClass(var stringArray: MutableList<String>, var clickInterface: ClickInterface) : RecyclerView.Adapter<RecyclerClass.ViewHolder>() {

    //view
    //find view by Id
    //view intialize
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var tvName = view.findViewById<TextView>(R.id.tvName)
    }

    //layout inflate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_reycler, parent, false)
        return ViewHolder(view)
    }

    //return items
    override fun getItemCount(): Int {
        return 4
    }

    //set text
    //click action perform
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(stringArray[position])

        holder.tvName.setOnClickListener {
            clickInterface.onItemClick(stringArray[position])
        }
    }
}