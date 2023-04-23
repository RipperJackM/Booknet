package com.example.booknet.ui.base.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.booknet.BR

abstract class RecyclerViewData {
    var adapterPosition: Int = -1
    var onListItemViewClickListener: KabRecyclerAdapter.OnListItemViewClickListener? = null
}

class KabRecyclerAdapter<T : RecyclerViewData>(
    @LayoutRes val layoutId: Int,
    list: List<T> = listOf(),
    var onListItemViewClickListener: OnListItemViewClickListener? = null
) : RecyclerView.Adapter<KabRecyclerAdapter.GenericViewHolder<T>>() {

    private val items = ArrayList<T>(list)

    val list: List<T>
        get() = items.toList()

    private var inflater: LayoutInflater? = null
    var lifecycleOwner: LifecycleOwner? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return GenericViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        val itemViewModel = items[position]
        itemViewModel.adapterPosition = position
        onListItemViewClickListener?.let { itemViewModel.onListItemViewClickListener = it }
        holder.bind(itemViewModel)
    }

    class GenericViewHolder<T : RecyclerViewData>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemViewModel: T) {
            binding.setVariable(BR.viewData, itemViewModel)
            binding.executePendingBindings()
        }
    }

    interface OnListItemViewClickListener {
        fun onClick(view: View, position: Int)
    }
}