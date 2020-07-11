package studio.juno.app.robert.onboarding.presentation.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import studio.juno.app.robert.onboarding.data.data_source.local.boolean

/**
 *
 *
 */
class SplashViewModel(sharedPreferences: SharedPreferences) : ViewModel() {

    /* */
    private var firstInit: Boolean
            by sharedPreferences.boolean(true, Key.FIRST_INIT)

    /**
     *
     *
     */
    fun isFirstInitNavigation() : Boolean {
        val value = firstInit
        firstInit = false
        return value
    }

    /**
     *
     *
     */
    private object Key {
        /* */
        const val FIRST_INIT: String = "FIRST_INIT"
    }

}
