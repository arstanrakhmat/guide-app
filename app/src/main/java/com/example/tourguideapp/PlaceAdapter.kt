package com.example.tourguideapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(var list: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_place, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val onePlace = list[position]
        holder.itemTitle.text = onePlace.title
        holder.itemSmallTitle.text = onePlace.smallTitle
        holder.details.text = onePlace.details
        holder.itemImage.setImageResource(onePlace.image)
        holder.location.text = onePlace.location
        holder.phoneNumber.text = onePlace.phoneNumber


        val isVisible: Boolean = onePlace.visibility
        holder.expLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.moreDetail.setOnClickListener {
            onePlace.visibility = !onePlace.visibility

            if (onePlace.visibility) {
                holder.moreDetail.setImageResource(R.drawable.ic_hide_info_item)
            } else {
                holder.moreDetail.setImageResource(R.drawable.ic_more_info_item)
            }

            notifyItemChanged(position)
        }

        val locationStr: String = holder.location.text.toString()
        holder.location.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=$locationStr")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            it.context.startActivity(mapIntent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemSmallTitle: TextView
        var details: TextView
        var location: TextView
        var phoneNumber: TextView
        var moreDetail: ImageView
        var expLayout: ConstraintLayout

        init {
            itemImage = itemView.findViewById(R.id.image_item)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemSmallTitle = itemView.findViewById(R.id.item_small_title)
            details = itemView.findViewById(R.id.details)
            location = itemView.findViewById(R.id.location)
            phoneNumber = itemView.findViewById(R.id.phoneNum)
            moreDetail = itemView.findViewById(R.id.more_info_button)
            expLayout = itemView.findViewById(R.id.expandable_layout)

        }
    }
}
