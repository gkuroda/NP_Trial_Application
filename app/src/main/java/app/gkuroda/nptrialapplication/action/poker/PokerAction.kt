package app.gkuroda.nptrialapplication.action.poker

import app.gkuroda.nptrialapplication.action.Action
import app.gkuroda.nptrialapplication.api.PokerResponse
import com.github.kittinunf.result.Result

sealed class PokerAction : Action {
    class GetPokerResult(val result: Result<PokerResponse, Exception>) : PokerAction()
}