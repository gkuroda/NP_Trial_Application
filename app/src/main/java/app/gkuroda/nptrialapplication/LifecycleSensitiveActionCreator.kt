package app.gkuroda.nptrialapplication

import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class LifecycleSensitiveActionCreator : LifecycleSensitive {
    protected val disposable = CompositeDisposable()

    override fun onDestroy() = disposable.dispose()
}