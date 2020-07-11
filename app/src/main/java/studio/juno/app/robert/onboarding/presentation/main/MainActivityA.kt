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
class MainActivityA : AppCompatActivity() {

    /**
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_a)
        setupViews()
    }

    /**
     *
     *
     */
    private fun setupViews(){
        fabNavigation.setOnClickListener { navigateToB() }
    }

    /**
     *
     *
     */
    private fun navigateToB(){
        Intent(this, MainActivityB::class.java).apply {
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
