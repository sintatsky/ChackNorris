package com.sintatsky.chacknorris.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.sintatsky.chacknorris.databinding.FragmentJokesBinding
import com.sintatsky.chacknorris.presentation.JokeApp
import com.sintatsky.chacknorris.presentation.Translator
import com.sintatsky.chacknorris.presentation.ViewModelFactory
import com.sintatsky.chacknorris.presentation.adapter.JokeListAdapter
import com.sintatsky.chacknorris.presentation.adapter.TranslatedJokeListAdapter
import com.sintatsky.chacknorris.presentation.viewmodel.JokesViewModel
import javax.inject.Inject


class JokesFragment : Fragment() {

    private lateinit var viewModel: JokesViewModel
    private lateinit var jokesAdapter: JokeListAdapter
    private lateinit var translatedJokeListAdapter: TranslatedJokeListAdapter

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
        translatedJokeListAdapter = TranslatedJokeListAdapter()
        binding.rvJokes.adapter = jokesAdapter
        binding.rvTranslateJokes.adapter = translatedJokeListAdapter
        binding.rvJokes.itemAnimator = null
        binding.rvTranslateJokes.itemAnimator = null

        viewModel = ViewModelProvider(this, viewModelFactory)[JokesViewModel::class.java]

        viewModel.jokeList.observe(viewLifecycleOwner) {
            jokesAdapter.submitList(it)
        }

        binding.btnTranslate.setOnClickListener {
            binding.separateLine.visibility = View.VISIBLE
            viewModel.jokeList.observe(viewLifecycleOwner) {
                translatedJokeListAdapter.submitList(it)
                Log.d("LOG", "tr: $it")
            }
        }

        binding.btnClear.setOnClickListener {
            binding.separateLine.visibility = View.GONE
            viewModel.jokeList.observe(viewLifecycleOwner) {
                translatedJokeListAdapter.submitList(null)
            }
        }

        binding.btnLoad.setOnClickListener {
            if (binding.etJokesCount.text!!.isNotEmpty()) {
                viewModel.loadData(binding.etJokesCount.text.toString().toInt())
            } else {
                Toast.makeText(
                    requireContext(),
                    "please, enter random number",
                    Toast.LENGTH_SHORT
                ).show()
            }
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
