package com.example.hilttraining.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hilttraining.databinding.NameCustomRowBinding
import javax.inject.Inject

//One way to provide binding information to Hilt is constructor injection.
// Use the @Inject annotation on the constructor of a class to tell Hilt how to provide instances of that class:

class NameAdapter @Inject constructor(private var onClickListener: OnNameClickListener) :
    RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    private var dataSource: List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            NameCustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = dataSource[position]
        holder.onBind(name)
    }

    override fun getItemCount(): Int = dataSource.size

    fun setDataSource(names: List<String>) {
        this.dataSource = names
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListener : OnNameClickListener){
        this.onClickListener = onClickListener
    }

    inner class ViewHolder(private var binding: NameCustomRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(name: String) {
            binding.nameTextView.text = name
            binding.nameTextView.setOnClickListener {
                Log.i("TestClick", "ViewHolder onItemClicked: name ----> $name")
                onClickListener.onItemClicked(name)
            }
        }
    }
}