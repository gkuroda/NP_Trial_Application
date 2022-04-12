package app.gkuroda.nptrialapplication.action.poker

import app.gkuroda.nptrialapplication.action.Action
import app.gkuroda.nptrialapplication.api.SearchResponse
import com.github.kittinunf.result.Result
import java.lang.Exception

sealed class PokerAction : Action {
    class GetPokerResult(val result : Result<SearchResponse, Exception>) : PokerAction()
}