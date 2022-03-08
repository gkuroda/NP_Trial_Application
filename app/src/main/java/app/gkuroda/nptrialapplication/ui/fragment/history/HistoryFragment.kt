package app.gkuroda.nptrialapplication.ui.fragment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.gkuroda.nptrialapplication.dagger.viewModel.ViewModelFactory
import app.gkuroda.nptrialapplication.databinding.FragmentHistoryBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HistoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: HistoryFragmentViewModel

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        binding = FragmentHistoryBinding.inflate(inflater)

        viewModel = viewModelFactory.get(this)


        return binding.root
    }

}