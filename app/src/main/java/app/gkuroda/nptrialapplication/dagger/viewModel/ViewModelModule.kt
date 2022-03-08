package app.gkuroda.nptrialapplication.dagger.viewModel

import androidx.lifecycle.ViewModel
import app.gkuroda.nptrialapplication.ui.MainActivityViewModel
import app.gkuroda.nptrialapplication.ui.fragment.history.HistoryFragmentViewModel
import app.gkuroda.nptrialapplication.ui.fragment.poker.PokerFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryFragmentViewModel::class)
    abstract fun historyFragmentViewModel(viewModel: HistoryFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokerFragmentViewModel::class)
    abstract fun pokerFragmentViewModel(viewModel: PokerFragmentViewModel): ViewModel

}