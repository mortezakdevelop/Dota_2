package com.example.dotalens.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.dotalens.R
import com.example.dotalens.databinding.ItemHeroesBinding
import com.example.dotalens.databinding.ItemTextBinding
import com.example.dotalens.model.AllHeroesState

class AllHeroesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding:ItemHeroesBinding
    private lateinit var textBinding:ItemTextBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return when (viewType){
           in 1 until differ.currentList.size + 1 ->  {
                val binding = ItemHeroesBinding.inflate(LayoutInflater.from(context),parent,false)
                ViewHolder(binding)
            }

           0 -> {
                val textBinding = ItemTextBinding.inflate(LayoutInflater.from(context),parent,false)
                TextViewHolder(textBinding)
            }

            else -> {
                val binding = ItemHeroesBinding.inflate(LayoutInflater.from(context),parent,false)
                ViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = differ.currentList[position]
        if (holder is ViewHolder){
            holder.bind(itemData)
        }else if (holder is TextViewHolder){
            holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

        class ViewHolder(private val binding: ItemHeroesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: AllHeroesState.AllHeroesStateItem) {
            binding.apply {
                tvHero.text = item.localizedName
                ivHero.load(item.img)
                //Glide.with(context).load(item.img).into(ivHero)
                Log.d("TAG", "bind:   ${item.img} ")
            }
        }
    }

        class TextViewHolder(private val textBinding: ItemTextBinding):RecyclerView.ViewHolder(textBinding.root){
            fun bind() {
                textBinding.tvTest.text = "this is test"
            }

        }

    private val differCallback = object : DiffUtil.ItemCallback<AllHeroesState.AllHeroesStateItem>(){
        override fun areItemsTheSame(
            oldItem: AllHeroesState.AllHeroesStateItem,
            newItem: AllHeroesState.AllHeroesStateItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AllHeroesState.AllHeroesStateItem,
            newItem: AllHeroesState.AllHeroesStateItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)
}