package app.gkuroda.nptrialapplication

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TrialApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return  app.gkuroda.nptrialapplication.dagger.DaggerApplicationComponent.factory().create(this)
    }
}