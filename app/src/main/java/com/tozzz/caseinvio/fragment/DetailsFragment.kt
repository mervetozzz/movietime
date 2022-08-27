package com.tozzz.caseinvio.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.tozzz.caseinvio.R
import com.tozzz.caseinvio.databinding.FragmentDetailsBinding
import com.tozzz.caseinvio.entity.MovieDetails
import com.tozzz.caseinvio.retrofit.ApiUtils
import com.tozzz.caseinvio.viewmodel.DetailPageViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewmodel : DetailPageViewModel
    var data : List<MovieDetails> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.detailToolbar = "Movies Detail"

        val bundle:DetailsFragmentArgs by navArgs()
        val mdetail = bundle.search
        binding.searchObj = mdetail

        val imdb  =  mdetail.imdbID

        if (imdb.isNotEmpty()){

        }

        return binding.root
    }
}