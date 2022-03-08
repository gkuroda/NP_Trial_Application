package app.gkuroda.nptrialapplication.dagger

import android.content.Context
import app.gkuroda.nptrialapplication.TrialApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun context(application: TrialApplication): Context = application

    @Provides
    fun testText():String = "test"
}