package app.gkuroda.nptrialapplication.api

import com.squareup.moshi.Json

data class PokerResponse(
    @Json(name = "result")
    val result: List<PokerResponseItem>
)

data class PokerResponseItem(
    @Json(name = "card")
    val card: String,
    @Json(name = "hand")
    val hand: String,
    @Json(name = "best")
    val best: Boolean
)