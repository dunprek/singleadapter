package com.don.singleadapter


/**
 * Created by gideon on 21,December,2018
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class SingleAdapter<T>(var listItems: List<T>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
            , viewType
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(listItems[position], context)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, listItems[position])
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    private fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderFactory.create(view, viewType)
    }

    internal interface Binder<T> {
        fun bind(data: T, context: Context)
    }


}