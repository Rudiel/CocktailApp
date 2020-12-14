package com.dacodes.myapplication.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ListViewModel {
    fun numberOfItems(): Int
    fun itemAt(position: Int): BaseViewModel
    fun selectItemAt(position: Int)
    fun morePagesAvailable(): Boolean
}

interface ListItemHolder {
    fun setup(itemViewModel: BaseViewModel)
}

abstract class BaseRecyclerViewAdapter (private val viewModel: ListViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return getViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position >= viewModel.numberOfItems())
            return
        holder.itemView.setOnClickListener {
            viewModel.selectItemAt(position)
        }

        val holderViewModel = viewModel.itemAt(position)
        (holder as ListItemHolder).setup(holderViewModel)

    }

    override fun getItemCount(): Int {
       return viewModel.numberOfItems()
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position)
    }
    protected abstract fun getLayoutId(position: Int): Int
    abstract fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder


}