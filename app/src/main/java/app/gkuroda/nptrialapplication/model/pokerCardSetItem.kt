package app.gkuroda.nptrialapplication.model

data class PokerCardSetItem(
    val orderNumber: Int,
    var firstCard: String = "",
    var secondCard: String = "",
    var thirdCard: String = "",
    var fourthCard: String = "",
    var fifthCard: String = "",
) {

    fun setCard(cardNumber: Int, cardValue: String): PokerCardSetItem {
        when (cardNumber) {
            1 -> this.firstCard = cardValue
            2 -> this.secondCard = cardValue
            3 -> this.thirdCard = cardValue
            4 -> this.fourthCard = cardValue
            5 -> this.fifthCard = cardValue
        }
        return this
    }

    /**
     * 現在のカード内容を1行にまとめます
     */
    fun toOneLineString(): String =
        "$firstCard $secondCard $thirdCard $fourthCard $fifthCard"

}