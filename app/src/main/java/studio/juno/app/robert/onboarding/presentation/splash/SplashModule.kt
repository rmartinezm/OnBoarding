package studio.juno.app.robert.onboarding.presentation.splash

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/* */
val splashModule = module {

    /* */
    viewModel { SplashViewModel(sharedPreferences = get()) }

}