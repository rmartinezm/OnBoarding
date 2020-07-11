package studio.juno.app.robert.onboarding.presentation.on_boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_on_boarding.*
import studio.juno.app.robert.onboarding.R
import studio.juno.app.robert.onboarding.presentation.extension.marginTabs
import studio.juno.app.robert.onboarding.presentation.main.MainActivityA
import studio.juno.app.robert.onboarding.presentation.on_boarding.adapter.OnBoardingPageAdapter
import studio.juno.app.robert.onboarding.presentation.on_boarding.model.Item
import studio.juno.app.robert.onboarding.presentation.on_boarding.model.MyItem

/**
 *
 *
 */
class OnBoardingActivity : AppCompatActivity() {

    /**
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setupViews()
    }

    /**
     *
     *
     */
    private fun setupViews() {
        viewPager.adapter = OnBoardingPageAdapter(
            getItems(),
            ::onSkipItemListener,
            ::onNextItemListener
        )
        tabLayout.marginTabs(8)
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->
            /* PASS */
        }.attach()
    }

    /**
     *
     * @return [List]
     */
    private fun getItems() : List<Item> = listOf(
        MyItem(R.raw.onboarding_first_item, 1, R.string.on_boarding_first_content, ::onAnimationCompletedListener, false),
        MyItem(R.raw.onboarding_second_item, 1, R.string.on_boarding_second_content, null, true)
    )

    /**
     *
     *
     */
    private fun onAnimationCompletedListener() {
        viewPager.currentItem = viewPager.currentItem.inc()
    }

    /**
     *
     *
     */
    private fun onSkipItemListener(){
        Intent(this, MainActivityA::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    /**
     *
     *
     */
    private fun onNextItemListener(){
        Intent(this, MainActivityA::class.java).apply {
            startActivity(this)
            finish()
        }
    }

}
