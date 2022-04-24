package com.sintatsky.chacknorris.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sintatsky.chacknorris.databinding.FragmentJokesBinding
import com.sintatsky.chacknorris.presentation.JokeApp
import com.sintatsky.chacknorris.presentation.ViewModelFactory
import com.sintatsky.chacknorris.presentation.adapter.JokeListAdapter
import com.sintatsky.chacknorris.presentation.viewmodel.JokesViewModel
import javax.inject.Inject


class JokesFragment : Fragment() {

    private lateinit var viewModel: JokesViewModel
    private lateinit var jokesAdapter: JokeListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as JokeApp).component
    }

    private var _binding: FragmentJokesBinding? = null
    private val binding: FragmentJokesBinding
        get() = _binding ?: throw RuntimeException("FragmentJokesBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJokesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jokesAdapter = JokeListAdapter()
        with(binding.rvJokes) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = jokesAdapter
            itemAnimator = null
        }

        viewModel = ViewModelProvider(this, viewModelFactory)[JokesViewModel::class.java]
        viewModel.jokeList.observe(viewLifecycleOwner) {
            jokesAdapter.submitList(it)
        }
        binding.btnLoad.setOnClickListener {
            viewModel.loadData(binding.etJokesCount.text.toString().toInt())
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        const val JOKES_FRAGMENT_TAG = "JOKES_FRAGMENT_TAG"
        fun newInstance() = JokesFragment()
    }
}
