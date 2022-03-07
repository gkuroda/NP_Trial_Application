package app.gkuroda.nptrialapplication.dagger

import app.gkuroda.nptrialapplication.TrialApplication
import app.gkuroda.nptrialapplication.dagger.viewModel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        ApplicationModule::class,
        ViewModelModule::class
    ]
)

interface ApplicationComponent : AndroidInjector<TrialApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TrialApplication>

}