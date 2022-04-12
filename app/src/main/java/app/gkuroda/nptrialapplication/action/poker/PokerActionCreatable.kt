package app.gkuroda.nptrialapplication.action.poker

interface PokerActionCreatable {
    /**
     * 検索のリクエストを行います
     */
    fun getPokerResult(queryString: String)
}