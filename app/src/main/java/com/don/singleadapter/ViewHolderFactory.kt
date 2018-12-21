package com.don.singleadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by gideon on 21,December,2018
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */


object ViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_list_user_name -> NameViewHolder(view)
            R.layout.item_list_user_detail -> OtherViewHolder(view)
            else -> {
                NameViewHolder(view)
            }
        }
    }


    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SingleAdapter.Binder<NameMdl> {
        override fun bind(data: NameMdl) {
            textView.text = data.name
        }

        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.tv_name)
        }

    }

    class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SingleAdapter.Binder<OtherMdl> {
        override fun bind(data: OtherMdl) {
            tvName.text = data.name
            tvAddress.text = data.address
        }

        var tvName: TextView
        var tvAddress: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_name)
            tvAddress = itemView.findViewById(R.id.tv_address)
        }
    }
}