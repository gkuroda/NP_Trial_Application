package app.gkuroda.nptrialapplication.model

import com.squareup.moshi.Json

data class PokerRequestModel(
    @Json(name = "cards")
    val cards: List<String>
) {
    companion object {
        /**
         * PokerCardSetItemのリストからリクエスト用モデルに変換します
         */
        fun convertPokerRequestModel(pokerCardSetItems: List<PokerCardSetItem>): PokerRequestModel =
            PokerRequestModel(
                cards = pokerCardSetItems.map { it.toOneLineString() }
            )
    }

}
