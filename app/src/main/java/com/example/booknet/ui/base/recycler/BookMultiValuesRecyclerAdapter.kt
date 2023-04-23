package com.example.booknet.ui.base.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.booknet.BR

abstract class MultiValuesRecyclerViewData : RecyclerViewData() {
    abstract val layoutId: Int
}

open class BookMultiValuesRecyclerAdapter(
    items: List<MultiValuesRecyclerViewData>,
    var onListItemViewClickListener: KabRecyclerAdapter.OnListItemViewClickListener? = null
) : RecyclerView.Adapter<BookMultiValuesRecyclerAdapter.Holder>() {

    private val items = ArrayList<MultiValuesRecyclerViewData>(items)

    val list: List<MultiValuesRecyclerViewData>
        get() = items.toList()

    var lifecycleOwner: LifecycleOwner? = null
    private var inflater: LayoutInflater? = null

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<MultiValuesRecyclerViewData>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    // Update list without specific start indexes
    fun updateList(list: List<MultiValuesRecyclerViewData>, fromIndex: Int) {
        items.clear()
        items.addAll(list)
        notifyItemRangeChanged(fromIndex, items.size - fromIndex)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemViewModel = items[position]
        itemViewModel.adapterPosition = position
        onListItemViewClickListener?.let { itemViewModel.onListItemViewClickListener = it }
        holder.bind(itemViewModel)
    }

    class Holder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemViewModel: MultiValuesRecyclerViewData) {
            binding.setVariable(BR.viewData, itemViewModel)
            binding.executePendingBindings()
        }
    }
}