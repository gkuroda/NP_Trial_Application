package app.gkuroda.nptrialapplication.ui.fragment.poker

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PokerFragmentViewModel @Inject constructor(
    private val testText: String
) : ViewModel() {
    init {
        Log.e("tag", "$testText")
    }

}