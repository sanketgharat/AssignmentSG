package com.sg.assignment.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sg.assignment.data.models.MainData
import com.sg.assignment.data.models.Product
import com.sg.assignment.databinding.RecyclerLayoutMainListBinding
import com.sg.assignment.databinding.RecyclerLayoutProductGridBinding
import com.sg.assignment.databinding.RecyclerLayoutProductListBinding
import com.sg.assignment.utils.GlideUtils

class ProductGridAdapter() : RecyclerView.Adapter<ProductGridAdapter.MyViewHolder>() {

    companion object {
        private const val TAG = "ProductGridAdapterT"
    }

    private var list: List<Product> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Product>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding =
            RecyclerLayoutProductGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
        payloads: List<Any?>
    ) {

        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            updateView(holder, position, payloads[0])
        }
    }

    private fun updateView(holder: MyViewHolder, position: Int, any: Any?) {
        //for single item ui update with data
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder grid: $position")
        val product = list[position]

        with(holder) {

            binding.textProductName.text = product.productName
            GlideUtils.setImage(
                binding.imageViewProduct.context,
                product.productImage,
                binding.imageViewProduct
            )

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: RecyclerLayoutProductGridBinding) :
        RecyclerView.ViewHolder(binding.root)


}