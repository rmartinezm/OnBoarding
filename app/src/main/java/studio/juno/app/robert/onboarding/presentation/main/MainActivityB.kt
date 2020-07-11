package studio.juno.app.robert.onboarding.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_a.*
import studio.juno.app.robert.onboarding.R

/**
 *
 *
 */
class MainActivityB : AppCompatActivity() {

    /**
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_b)
        setupViews()
    }

    /**
     *
     *
     */
    private fun setupViews(){
        fabNavigation.setOnClickListener { navigateToA() }
    }

    /**
     *
     *
     */
    private fun navigateToA(){
        Intent(this, MainActivityA::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    /**
     *
     *
     */
    override fun onBackPressed() {
        moveTaskToBack(true)
    }

}
