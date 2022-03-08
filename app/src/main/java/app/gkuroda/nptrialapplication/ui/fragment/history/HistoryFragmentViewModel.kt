package app.gkuroda.nptrialapplication.ui.fragment.history

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HistoryFragmentViewModel@Inject constructor(
    private val testText: String
) : ViewModel() {
    init {
        Log.e("tag", "$testText")
    }

}