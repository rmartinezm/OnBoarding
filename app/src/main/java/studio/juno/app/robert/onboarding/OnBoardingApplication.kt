package studio.juno.app.robert.onboarding

import android.app.Application
import studio.juno.app.robert.onboarding.di.initKoin

/**
 *
 *
 */
class OnBoardingApplication : Application() {

    /**
     *
     *
     */
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

}