package studio.juno.app.robert.onboarding.di

import org.koin.dsl.module.Module
import studio.juno.app.robert.onboarding.OnBoardingApplication
import org.koin.android.ext.android.startKoin
import studio.juno.app.robert.onboarding.data.data_source.local.sharedPreferencesModule
import studio.juno.app.robert.onboarding.presentation.splash.splashModule


/**
 *
 *
 */
fun OnBoardingApplication.initKoin() {
    val dataSourceModules = getDataSourceModules()
    val presentationModules = getPresentationModules()
    val modules = dataSourceModules + presentationModules
    startKoin(applicationContext, modules)
}

/**
 *
 * @return [List]
 */
private fun getDataSourceModules() : List<Module> = listOf(sharedPreferencesModule)

/**
 *
 * @return [List]
 */
private fun getPresentationModules() : List<Module> = listOf(
    splashModule
)
