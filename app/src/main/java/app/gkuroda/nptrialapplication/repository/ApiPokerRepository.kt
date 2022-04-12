package app.gkuroda.nptrialapplication.repository

import app.gkuroda.nptrialapplication.api.PokerApi
import app.gkuroda.nptrialapplication.api.SearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit

class ApiPokerRepository(retrofit: Retrofit) : PokerRepository {

    private val pokerApi: PokerApi = retrofit.create(PokerApi::class.java)

    override fun getPokerResult(queryString: String): Single<SearchResponse> {
        return pokerApi.getPokerResult(queryString)
    }
}