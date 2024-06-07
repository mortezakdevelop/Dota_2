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
import com.example.dotalens.model.AllHeroesState

class AllHeroesAdapter: RecyclerView.Adapter<AllHeroesAdapter.ViewHolder>() {

    private lateinit var binding:ItemHeroesBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllHeroesAdapter.ViewHolder {
        context = parent.context
        binding = ItemHeroesBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: AllHeroesAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder():RecyclerView.ViewHolder(binding.root){
        fun bind(item: AllHeroesState.AllHeroesStateItem) {
            binding.apply {
                tvHero.text = item.localizedName
                //ivHero.load(item.img)
                Glide.with(context).load(item.img).into(ivHero)
                Log.d("TAG", "bind:   ${item.img} ")
            }
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