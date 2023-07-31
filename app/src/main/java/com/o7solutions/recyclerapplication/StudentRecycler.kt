package com.o7solutions.recyclerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author: 017
 * @Date: 31/07/23
 * @Time: 2:15 pm
 */
class StudentRecycler(var student: ArrayList<Student>) : RecyclerView.Adapter<StudentRecycler.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvClass = view.findViewById<TextView>(R.id.tvClass)
        var tvRollno = view.findViewById<TextView>(R.id.tvRollno)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return student.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(student[position].name)
        holder.tvClass.setText(student[position].sClass)
        holder.tvRollno.setText(student[position].id.toString())
    }
}