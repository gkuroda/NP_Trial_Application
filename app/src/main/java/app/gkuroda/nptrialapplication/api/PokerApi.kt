package app.gkuroda.nptrialapplication.api

import app.gkuroda.nptrialapplication.model.PokerRequestModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface PokerApi {
    @POST("/api/v1/cards/check")
    fun getPokerResult(@Body cards: PokerRequestModel): Single<PokerResponse>
}