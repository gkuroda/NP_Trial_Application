package app.gkuroda.nptrialapplication.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val baseApiPath: String
) : ViewModel() {
    init {
        Log.e("tag", "$baseApiPath")
    }

}