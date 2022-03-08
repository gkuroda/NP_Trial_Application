package app.gkuroda.nptrialapplication.dagger

import app.gkuroda.nptrialapplication.ui.MainActivity
import app.gkuroda.nptrialapplication.ui.fragment.history.HistoryFragment
import app.gkuroda.nptrialapplication.ui.fragment.poker.PokerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity


    @ContributesAndroidInjector
    abstract fun contributeHistoryFragment(): HistoryFragment


    @ContributesAndroidInjector
    abstract fun contributePokerFragment(): PokerFragment

}