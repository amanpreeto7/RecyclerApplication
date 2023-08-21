package com.o7solutions.recyclerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


/**
 * @Author: 017
 * @Date: 01/08/23
 * @Time: 12:36 pm
 */
class NewAdapter(var studentArray: ArrayList<Student>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var viewType = 0
     public class RightViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
         var tvRight: TextView
         init {
              tvRight = view.findViewById<TextView>(R.id.tvRight)
         }
     }

     public class LeftViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
         var tvLeft: TextView
         init {
             tvLeft = view.findViewById<TextView>(R.id.tvLeft)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view : View
        System.out.println("viewType $viewType this.viewType ${this.viewType}")
        if(this.viewType == 0){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_left, parent, false)
            return LeftViewHolder(view)

        }else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_right, parent, false)
            return RightViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(position % 2 == 0){
            viewType = 1
        }else{
            viewType = 0
        }
        return super.getItemViewType(position)

    }

    override fun getItemCount(): Int {
        return studentArray.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RightViewHolder->{ (holder as RightViewHolder).tvRight.setText("Right $position")}
            is LeftViewHolder->{ (holder as LeftViewHolder).tvLeft.setText("Left $position")}
        }
    }
}