package app.gkuroda.nptrialapplication.repository

import app.gkuroda.nptrialapplication.api.PokerApi
import app.gkuroda.nptrialapplication.api.PokerResponse
import app.gkuroda.nptrialapplication.model.PokerRequestModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit

class ApiPokerRepository(retrofit: Retrofit) : PokerRepository {

    private val pokerApi: PokerApi = retrofit.create(PokerApi::class.java)

    override fun getPokerResult(pokerRequestModel: PokerRequestModel): Single<PokerResponse> {
        return pokerApi.getPokerResult(pokerRequestModel)
    }
}