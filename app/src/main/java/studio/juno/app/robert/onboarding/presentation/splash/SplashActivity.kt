package studio.juno.app.robert.onboarding.presentation.splash

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.viewmodel.ext.android.viewModel
import studio.juno.app.robert.onboarding.R
import studio.juno.app.robert.onboarding.presentation.extension.isCompleted
import studio.juno.app.robert.onboarding.presentation.main.MainActivityA
import studio.juno.app.robert.onboarding.presentation.on_boarding.OnBoardingActivity

/**
 *
 *
 */
class SplashActivity : AppCompatActivity() {

    /* */
    private val splashViewModel by viewModel<SplashViewModel>()

    /**
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupViews()
    }

    /**
     *
     *
     */
    private fun setupViews(){
        lavAnimation.addAnimatorUpdateListener(::getAnimatorUpdateListener)

    }

    /**
     *
     * @param animation
     */
    private fun getAnimatorUpdateListener(animation: ValueAnimator) {
        if(animation.isCompleted){
            val destination = if(splashViewModel.isFirstInitNavigation())
                OnBoardingActivity::class.java
            else MainActivityA::class.java
            lavAnimation.removeAllAnimatorListeners()
            navigateTo(destination)
        }
    }

    /**
     *
     *
     */
    private fun navigateTo(destination: Class<*>) {
        Intent(this, destination).apply {
            startActivity(this)
            finish()
        }
    }

}
