package app.gkuroda.nptrialapplication.dagger

import android.content.Context
import app.gkuroda.nptrialapplication.Dispatcher
import app.gkuroda.nptrialapplication.R
import app.gkuroda.nptrialapplication.TrialApplication
import app.gkuroda.nptrialapplication.action.poker.PokerActionCreatable
import app.gkuroda.nptrialapplication.action.poker.PokerActionCreator
import app.gkuroda.nptrialapplication.repository.ApiPokerRepository
import app.gkuroda.nptrialapplication.repository.PokerRepository
import app.gkuroda.nptrialapplication.store.Store
import app.gkuroda.nptrialapplication.store.StoreInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    fun context(application: TrialApplication): Context = application

    @Provides
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

   @Singleton
   @Provides
   fun baseApiPath(context: Context): String = context.getString(R.string.api_base_url)

    @Singleton
    @Provides
    fun moshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, moshi: Moshi, baseApiPath: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseApiPath)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun store(dispatcher: Dispatcher): StoreInterface = Store(dispatcher)

    @Provides
    fun searchActionCreator(
        dispatcher: Dispatcher,
        searchRepository: PokerRepository
    ): PokerActionCreatable = PokerActionCreator(dispatcher, searchRepository)

    @Singleton
    @Provides
    fun searchRepository(retrofit: Retrofit): PokerRepository = ApiPokerRepository(retrofit)
}