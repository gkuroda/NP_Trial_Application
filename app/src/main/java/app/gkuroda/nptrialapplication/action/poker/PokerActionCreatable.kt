package app.gkuroda.nptrialapplication.action.poker

import app.gkuroda.nptrialapplication.model.PokerRequestModel

interface PokerActionCreatable {
    /**
     * 検索のリクエストを行います
     */
    fun getPokerResult(pokerRequestModel: PokerRequestModel)
}