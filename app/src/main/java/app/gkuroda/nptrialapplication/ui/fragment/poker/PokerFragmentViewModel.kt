package app.gkuroda.nptrialapplication.ui.fragment.poker

import androidx.lifecycle.ViewModel
import app.gkuroda.nptrialapplication.action.poker.PokerActionCreatable
import app.gkuroda.nptrialapplication.api.PokerResponse
import app.gkuroda.nptrialapplication.model.PokerCardSetItem
import app.gkuroda.nptrialapplication.model.PokerRequestModel
import app.gkuroda.nptrialapplication.store.StoreInterface
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success
import com.jakewharton.rxrelay3.BehaviorRelay
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class PokerFragmentViewModel @Inject constructor(
    private val store: StoreInterface,
    private val searchActionCreator: PokerActionCreatable
) : ViewModel() {

    private val disposable = CompositeDisposable()

    // 結果連携用
    val pokerResult: BehaviorRelay<PokerResponse> = BehaviorRelay.create()

    //エラー連携用
    val pokerError: PublishRelay<Exception> = PublishRelay.create()

    init {
        subscribeStore()
    }

    /**
     * Storeの更新を購読します
     */
    private fun subscribeStore() {
        store.pokerResult
            .subscribe { result ->
                result.success {
                    pokerResult.accept(it)
                }
                result.failure {
                    pokerError.accept(it)
                }

            }.addTo(disposable)
    }


    /**
     * ポーカーの役のリクエストを行います
     */
    fun requestPokerHand(pokerCardSetItems: List<PokerCardSetItem>) {
        searchActionCreator.getPokerResult(
            PokerRequestModel.convertPokerRequestModel(
                pokerCardSetItems
            )
        )
    }


}