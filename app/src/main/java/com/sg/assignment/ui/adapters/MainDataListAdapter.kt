package com.sg.assignment.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sg.assignment.data.models.MainData
import com.sg.assignment.data.models.Product
import com.sg.assignment.databinding.RecyclerLayoutMainListBinding
import com.sg.assignment.utils.GlideUtils
import androidx.recyclerview.widget.DividerItemDecoration


class MainDataListAdapter : RecyclerView.Adapter<MainDataListAdapter.MyViewHolder>() {

    companion object {
        private const val TAG = "MainDataListAdapter"
    }

    private var list: List<MainData> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<MainData>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding =
            RecyclerLayoutMainListBinding.inflate(
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
        Log.d(TAG, "onBindViewHolder main: $position")
        val mainData = list[position]

        with(holder) {
            when (mainData.type) {
                MainData.TYPE_BANNER_IMAGE -> {
                    binding.imageView.visibility = View.VISIBLE
                    binding.recyclerInner.visibility = View.GONE

                    GlideUtils.setImage(
                        binding.imageView.context,
                        mainData.imageUrl,
                        binding.imageView
                    )
                }
                MainData.TYPE_LIST -> {
                    binding.imageView.visibility = View.GONE
                    binding.recyclerInner.visibility = View.VISIBLE

                    initListRecycler(
                        binding.imageView.context,
                        binding.recyclerInner,
                        mainData.dataList
                    )
                }
                MainData.TYPE_GRID -> {
                    binding.imageView.visibility = View.GONE
                    binding.recyclerInner.visibility = View.VISIBLE

                    initGridRecycler(
                        binding.imageView.context,
                        binding.recyclerInner,
                        mainData.columns,
                        mainData.dataList
                    )
                }
                else -> {
                    binding.imageView.visibility = View.GONE
                    binding.recyclerInner.visibility = View.GONE
                }
            }
        }

    }

    private fun initListRecycler(
        context: Context,
        recyclerView: RecyclerView,
        list: List<Product>
    ) {
        Log.d(TAG, "initListRecycler:")
        val adapter = ProductListAdapter()
        val layoutManager = LinearLayoutManager(context.applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        adapter.setList(list)
    }

    private fun initGridRecycler(
        context: Context,
        recyclerView: RecyclerView,
        columns: Int,
        list: List<Product>
    ) {
        Log.d(TAG, "initGridRecycler:")
        val adapter = ProductGridAdapter()
        val layoutManager = GridLayoutManager(context.applicationContext, columns)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        adapter.setList(list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: RecyclerLayoutMainListBinding) :
        RecyclerView.ViewHolder(binding.root)


}