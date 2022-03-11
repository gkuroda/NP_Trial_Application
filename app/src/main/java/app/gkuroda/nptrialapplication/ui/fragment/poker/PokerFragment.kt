package app.gkuroda.nptrialapplication.ui.fragment.poker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.gkuroda.nptrialapplication.dagger.viewModel.ViewModelFactory
import app.gkuroda.nptrialapplication.databinding.FragmentPokerBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PokerFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: PokerFragmentViewModel

    private lateinit var binding: FragmentPokerBinding

    lateinit var recyclerViewAdapter: PokerHandRequestRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        binding = FragmentPokerBinding.inflate(inflater)

        viewModel = viewModelFactory.get(this)
        setUpRecyclerView()
        return binding.root
    }

    fun setUpRecyclerView() {
        recyclerViewAdapter = PokerHandRequestRecyclerViewAdapter(requireContext())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.setPokerItemList()
        recyclerViewAdapter.notifyDataSetChanged()
    }


}