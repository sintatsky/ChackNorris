package com.sintatsky.chacknorris.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sintatsky.chacknorris.databinding.ItemJokeBinding
import com.sintatsky.chacknorris.domain.entity.JokesValue

class JokeListAdapter :
    ListAdapter<JokesValue, JokeListAdapter.JokeViewHolder>(JokesDiffCallback()) {

    class JokeViewHolder(val binding: ItemJokeBinding) : RecyclerView.ViewHolder(binding.root)

    class JokesDiffCallback : DiffUtil.ItemCallback<JokesValue>() {
        override fun areItemsTheSame(oldItem: JokesValue, newItem: JokesValue) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: JokesValue, newItem: JokesValue) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JokeViewHolder {
        val binding = ItemJokeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = getItem(position)
        holder.binding.tvJoke.text = joke.joke
    }
}