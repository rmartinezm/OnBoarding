package studio.juno.app.robert.onboarding.presentation.extension

import android.animation.ValueAnimator

/* */
val ValueAnimator.isCompleted : Boolean
    get() = (animatedValue as Float) in 0.99f..1.0f