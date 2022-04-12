package app.gkuroda.nptrialapplication.action.poker

import app.gkuroda.nptrialapplication.Dispatcher
import app.gkuroda.nptrialapplication.LifecycleSensitiveActionCreator
import app.gkuroda.nptrialapplication.api.PokerResponse
import app.gkuroda.nptrialapplication.model.PokerRequestModel
import app.gkuroda.nptrialapplication.repository.PokerRepository
import com.github.kittinunf.result.Result
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class PokerActionCreator(
    private val dispatcher: Dispatcher,
    private val pokerRepository: PokerRepository
) : LifecycleSensitiveActionCreator(), PokerActionCreatable {
    override fun getPokerResult(pokerRequestModel: PokerRequestModel) {
        pokerRepository.getPokerResult(pokerRequestModel)
            .subscribeOn(Schedulers.io())
            .map<Result<PokerResponse, Exception>> {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it as Exception)
            }
            .map(PokerAction::GetPokerResult)
            .subscribe(dispatcher::dispatch)
            .addTo(disposable)
    }
}