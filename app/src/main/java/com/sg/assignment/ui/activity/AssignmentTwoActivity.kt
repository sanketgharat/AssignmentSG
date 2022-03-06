package com.sg.assignment.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sg.assignment.data.DataRepository
import com.sg.assignment.databinding.ActivityAssignmentTwoBinding
import com.sg.assignment.ui.adapters.MainDataListAdapter
import com.sg.assignment.viewmodel.MainViewModel

class AssignmentTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssignmentTwoBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapterMainDataList: MainDataListAdapter

    companion object {
        private const val TAG = "AssignmentTwoActivityT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DataRepository(applicationContext)
        viewModel = ViewModelProvider(this, MainViewModel.FACTORY(repository)).get(MainViewModel::class.java)


        initViews()
        initObservers()
        loadData()
    }

    private fun initViews(){
        initRecycler()
    }
    private fun initRecycler() {
        adapterMainDataList = MainDataListAdapter()
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerMain.layoutManager = layoutManager
        binding.recyclerMain.itemAnimator = DefaultItemAnimator()
        binding.recyclerMain.adapter = adapterMainDataList
    }

    private fun initObservers(){
        viewModel.dataList.observe(this){ dataList ->
            dataList?.let {
                adapterMainDataList.setList(it)
            }
        }
    }

    private fun loadData(){
        viewModel.getData()
    }

}