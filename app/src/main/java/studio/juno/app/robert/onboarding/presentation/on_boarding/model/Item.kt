package studio.juno.app.robert.onboarding.presentation.on_boarding.model

/**
 *
 *
 */
interface Item {

    /* */
    val animRes: Int
    /* */
    val animRepeat: Int
    /* */
    val contentRes: Int
    /* */
    val onAnimationCompleteListener: (() -> Unit)?
    /* */
    val isButtonShowing: Boolean

}