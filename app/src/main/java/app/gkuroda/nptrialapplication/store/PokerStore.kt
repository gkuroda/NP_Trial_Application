package app.gkuroda.nptrialapplication.store

import app.gkuroda.nptrialapplication.Dispatcher
import app.gkuroda.nptrialapplication.action.poker.PokerAction
import app.gkuroda.nptrialapplication.api.SearchResponse
import com.github.kittinunf.result.Result
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.kotlin.addTo
import java.lang.Exception

interface PokerStore {
    val pokerResult: BehaviorRelay<Result<SearchResponse, Exception>>
}

fun Store.subscribePokerStore(dispatcher: Dispatcher) {
    dispatcher.onImpl<PokerAction.GetPokerResult>()
        .map { it.result }
        .subscribe(pokerResult::accept)
        .addTo(disposable)
}