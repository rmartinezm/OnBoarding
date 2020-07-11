package studio.juno.app.robert.onboarding.data.data_source.local

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/* */
val sharedPreferencesModule = module {

    /* */
    single<SharedPreferences> {
        androidApplication().getSharedPreferences(
            androidApplication().packageName,
            Context.MODE_PRIVATE
        )
    }

}