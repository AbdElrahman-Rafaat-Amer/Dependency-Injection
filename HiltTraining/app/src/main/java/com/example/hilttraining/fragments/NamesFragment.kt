package com.example.hilttraining.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilttraining.adapter.NameAdapter
import com.example.hilttraining.adapter.OnNameClickListener
import com.example.hilttraining.databinding.FragmentNamesBinding
import com.example.hilttraining.viewmodel.NamesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NamesFragment @Inject constructor(private val someString: String) : Fragment() {
    private lateinit var binding: FragmentNamesBinding
    private val namesViewModel: NamesViewModel by viewModels()

    @Inject //Filed Injection
    lateinit var nameAdapter: NameAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNamesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initRecyclerView()
        subscribeObservers()
    }

    private fun initUI() {
        binding.nameEditText.setText(someString)
        binding.saveButton.setOnClickListener {
            namesViewModel.addName(binding.nameEditText.text.toString())
            binding.nameEditText.text.clear()
        }

        binding.nextButton.setOnClickListener {
            //ChangeFragment
        }
    }

    private fun initRecyclerView() {
        binding.nameRecyclerView.apply {
            val customLayoutManager = LinearLayoutManager(requireContext())
            customLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = customLayoutManager
            adapter = nameAdapter
        }

        nameAdapter.setOnClickListener(object : OnNameClickListener {
            override fun onItemClicked(name: String) {
                Log.i("TestClick", "NamesFragment onItemClicked: name ----> $name")
                Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun subscribeObservers() {
        namesViewModel.names.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                nameAdapter.setDataSource(it)
            }
        }
    }

/*    private fun subscribeObservers() {
        viewModel.dataState.observe(owner: viewLifeCycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(isDisplaved: false)
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(isDisplaved: false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(isDisplaved:true)
                }
            }
        })
    }*/
}