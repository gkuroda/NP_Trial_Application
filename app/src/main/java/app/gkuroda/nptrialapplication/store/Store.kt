package app.gkuroda.nptrialapplication.store

import app.gkuroda.nptrialapplication.Dispatcher
import app.gkuroda.nptrialapplication.action.Action
import app.gkuroda.nptrialapplication.api.PokerResponse
import com.github.kittinunf.result.Result
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class Store(private val dispatcher: Dispatcher) : StoreInterface {

    val reducerThread: Scheduler = Schedulers.computation()

    val disposable = CompositeDisposable()

    override val pokerResult: BehaviorRelay<Result<PokerResponse, Exception>> =
        BehaviorRelay.create()

    init {
        subscribe()
    }

    private fun subscribe() {
        subscribePokerStore(dispatcher)
    }

    inline fun <reified T : Action> Dispatcher.onImpl(): Flowable<T> =
        on<T>().observeOn(reducerThread)

}