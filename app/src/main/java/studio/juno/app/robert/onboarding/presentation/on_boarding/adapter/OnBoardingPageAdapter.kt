package studio.juno.app.robert.onboarding.presentation.on_boarding.adapter

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import studio.juno.app.robert.onboarding.R
import studio.juno.app.robert.onboarding.presentation.extension.isCompleted
import studio.juno.app.robert.onboarding.presentation.extension.layoutInflater
import studio.juno.app.robert.onboarding.presentation.on_boarding.model.Item

/**
 *
 * @param items
 * @param onSkipButtonClickListener
 * @param onNextButtonClickListener
 */
class OnBoardingPageAdapter(
    private val items: List<Item>,
    private val onSkipButtonClickListener: () -> Unit,
    private val onNextButtonClickListener: () -> Unit
) : RecyclerView.Adapter<OnBoardingPageAdapter.ViewHolder>() {

    /**
     *
     * @param parent
     * @param viewType
     * @return [ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.layoutInflater.inflate(R.layout.adapter_on_boarding_page, parent, false))

    /**
     *
     * @return [Int]
     */
    override fun getItemCount(): Int = items.size

    /**
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.configureViewHolderByItem(item)
    }

    /**
     *
     * @param itemView
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        /* */
        private val ivSkip: ImageView
                by lazy { itemView.findViewById<ImageView>(R.id.ivSkip) }
        /* */
        private val lavAnimation: LottieAnimationView
                by lazy { itemView.findViewById<LottieAnimationView>(R.id.lavAnimation) }
        /* */
        private val tvContent: TextView
                by lazy { itemView.findViewById<TextView>(R.id.tvContent) }
        /* */
        private val btnNext: Button
                by lazy { itemView.findViewById<Button>(R.id.btnNext) }
        /* */
        private var auxItemRepeat: Int = 0


        /**
         *
         * @param item
         */
        fun configureViewHolderByItem(item: Item){
            ivSkip.setOnClickListener { onSkipButtonClickListener() }
            lavAnimation.let {
                it.setAnimation(item.animRes)
                it.repeatCount = item.animRepeat
                auxItemRepeat = item.animRepeat
                item.onAnimationCompleteListener?.let { listener ->
                    it.addAnimatorUpdateListener { animation ->
                        getAnimatorUpdateListener(animation, listener)
                    }
                }
                it.playAnimation()
            }
            tvContent.text = itemView.context.getString(item.contentRes)
            if(item.isButtonShowing) {
                btnNext.visibility = View.VISIBLE
                btnNext.setOnClickListener { onNextButtonClickListener() }
            }
        }

        /**
         *
         * @param animation
         * @param onCompleted
         */
        private fun getAnimatorUpdateListener(animation: ValueAnimator, onCompleted: () -> Unit) {
            if(animation.isCompleted) {
                if(auxItemRepeat-- < 1)
                    onCompleted()
            }
        }

    }

}
