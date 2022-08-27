package com.tozzz.caseinvio.adapter

import `in`.example.moviesapp.network.model.SearchX
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tozzz.caseinvio.databinding.CardDesignBinding
import com.tozzz.caseinvio.entity.MovieDetails
import com.tozzz.caseinvio.fragment.MainPageFragmentDirections
import com.tozzz.caseinvio.viewmodel.MainPageFragmentViewModel

class MovieAdapter(var mContext: Context) : RecyclerView.Adapter<MovieAdapter.CardDesign>() {
    var movieDetailsList: List<SearchX> = ArrayList()

    inner class CardDesign(binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: CardDesignBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val search = movieDetailsList[position]
        val t = holder.binding
        t.movieObj = search
        Picasso.get().load(movieDetailsList[position].poster).into(t.ivPoster)

        t.sCard.setOnClickListener {
            val trans = MainPageFragmentDirections.toDetail(search = search)
            Navigation.findNavController(it).navigate(trans)
        }
    }

    override fun getItemCount(): Int {
        return movieDetailsList.size
    }

}