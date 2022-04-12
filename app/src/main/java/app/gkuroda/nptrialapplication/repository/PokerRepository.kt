package app.gkuroda.nptrialapplication.repository

import app.gkuroda.nptrialapplication.api.PokerResponse
import app.gkuroda.nptrialapplication.model.PokerRequestModel
import io.reactivex.rxjava3.core.Single

interface PokerRepository {
    fun getPokerResult(pokerRequestModel: PokerRequestModel): Single<PokerResponse>
}