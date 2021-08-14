package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var dataList: List<CollegeData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title=view.title
        var designation = view.designation
        var type = view.type
        var identity = view.identity
        var image = view.friend_img

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PersonDetail::class.java)
            intent.putExtra("planet",dataList[position])

            holder.itemView.context.startActivity(intent)

        }
        holder.designation.text = dataList[position].designation
        holder.identity.text = dataList[position].identity
        holder.type.text = dataList[position].type
        holder.title.text = dataList[position].title
        holder.image.setImageResource(dataList[position].image!!)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

