package com.velev.outdoorsy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.velev.outdoorsy.R
import com.velev.outdoorsy.data.Vehicle

/**
 * @author Iliya Velev
 * @since 1.0
 */
class VehicleAdapter : RecyclerView.Adapter<VehicleAdapter.Holder>() {

    private val items = ArrayList<Vehicle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_vehicle, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.name.text = item.name
        Glide.with(holder.image.context)
            .load(item.imageUrl)
            .into(holder.image)
    }

    fun setItems(vehicles: List<Vehicle>) {
        items.clear()
        items.addAll(vehicles)

        // TODO make it with DiffUtil
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : AppCompatTextView = itemView.findViewById(R.id.name)
        val image: AppCompatImageView = itemView.findViewById(R.id.image)
    }
}