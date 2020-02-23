package com.example.fivesystembroadcasts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*
import com.example.fivesystembroadcasts.UserData

class UserAdapter(val resultList: List<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))

    override fun getItemCount() = resultList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.populateItem(resultList[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun populateItem(result : UserData){
            itemView.tvName.text = result.name
            itemView.tvEmail.text = result.email
            itemView.tvPhoneNum.text = result.phone
            Glide
                .with(itemView)
                .load(result.picture)
                .into(itemView.imgUserImage)

        }
    }

}