package studio.juno.app.robert.onboarding.presentation.extension

import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout

/**
 *
 * @param margin
 */
fun TabLayout.marginTabs(margin: Int) {
    for (i in 0 until tabCount) {
        val lateralMargin: Int = margin / 2
        val tab = (getChildAt(0) as ViewGroup).getChildAt(i)
        val p = tab.layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(lateralMargin, 0, lateralMargin, 0)
        tab.requestLayout()
    }
}