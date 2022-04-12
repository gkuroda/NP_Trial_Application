package app.gkuroda.nptrialapplication.model

import com.squareup.moshi.Json

data class PokerRequestModel(
    @Json(name = "cards")
    val cards: List<String>
)
