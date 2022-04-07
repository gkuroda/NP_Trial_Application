package app.gkuroda.nptrialapplication.ui.fragment.poker

interface PokerItemEvent {
    fun onTextChange(orderNumber: Int, cardNumber: Int, cardValue: CharSequence)
}