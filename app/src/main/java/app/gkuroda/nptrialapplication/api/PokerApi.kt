package app.gkuroda.nptrialapplication.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PokerApi {
    @GET("/api/v1/cards/check")
    fun getPokerResult(@Query("q") query: String): Single<SearchResponse>
}