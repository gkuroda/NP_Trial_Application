package app.gkuroda.nptrialapplication.repository

import app.gkuroda.nptrialapplication.api.SearchResponse
import io.reactivex.rxjava3.core.Single

interface PokerRepository {
    fun getPokerResult(queryString: String): Single<SearchResponse>
}