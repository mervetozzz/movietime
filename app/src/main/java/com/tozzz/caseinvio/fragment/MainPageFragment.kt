package com.tozzz.caseinvio.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.tozzz.caseinvio.R
import com.tozzz.caseinvio.adapter.MovieAdapter
import com.tozzz.caseinvio.databinding.FragmentMainPageBinding
import com.tozzz.caseinvio.viewmodel.MainPageFragmentViewModel


class MainPageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MainPageFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)
        binding.mainPageFragment = this
        binding.mainPageToolbar = "Movies"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)

        //Dinleme işlemi
        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter = MovieAdapter(requireContext())
            binding.movieAdapter = adapter
           // adapter.notifyDataSetChanged()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel


        viewModel.showProgress.observe(this, androidx.lifecycle.Observer{
            if (it)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        searchView.queryHint = "Search a movie.."
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
            viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
            viewModel.search(newText)
        return true
    }

}