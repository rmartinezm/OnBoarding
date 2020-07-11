package studio.juno.app.robert.onboarding.presentation.on_boarding.model

/**
 *
 * @param animRes
 * @param animRepeat
 * @param contentRes
 * @param onAnimationCompleteListener
 * @param isButtonShowing
 */
class MyItem(
    override val animRes: Int,
    override val animRepeat: Int,
    override val contentRes: Int,
    override val onAnimationCompleteListener: (() -> Unit)? = null,
    override val isButtonShowing: Boolean
) : Item

