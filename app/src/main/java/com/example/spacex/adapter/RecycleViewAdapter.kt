package com.example.spacex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spacex.R
import com.example.spacex.datas.SpaceXDataItem
import kotlinx.android.synthetic.main.grid_view_item.view.*

class RecycleViewAdapter(val context:Context, val spaceDataList: List<SpaceXDataItem>):
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var img : ImageView
        var name: TextView
        var date: TextView
        init {
            img = itemView.imageViewer
            name = itemView.imageName
            date = itemView.imageDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var items = LayoutInflater.from(context).inflate(R.layout.grid_view_item, parent, false)
        return ViewHolder(items)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = spaceDataList[position].name
        holder.date.text = spaceDataList[position].date_utc
        Glide.with(context).load(spaceDataList[position].links.patch.small).into(holder.img)
    }

    override fun getItemCount(): Int {
        return spaceDataList.size
    }

}