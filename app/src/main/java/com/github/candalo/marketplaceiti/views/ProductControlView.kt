package com.github.candalo.marketplaceiti.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.candalo.marketplaceiti.R

class ProductControlView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle)  {

    private var productsCount = 1
    private val decrementButton: ImageButton
    private val incrementButton: ImageButton
    private val productsNumber: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_product_control, this, true).also {
            decrementButton = findViewById(R.id.decrement)
            incrementButton = findViewById(R.id.increment)
            productsNumber = findViewById(R.id.productsNumber)
            productsNumber.text = productsCount.toString()

            decrementButton.setOnClickListener {
                if (productsCount == 0) return@setOnClickListener
                productsNumber.text = "${--productsCount}"
            }

            incrementButton.setOnClickListener {
                productsNumber.text = "${++productsCount}"
            }
        }
    }

    fun setButtonsColor(hexColor: String) {
        decrementButton.setBackgroundColor(Color.parseColor(hexColor))
        incrementButton.setBackgroundColor(Color.parseColor(hexColor))
    }

    fun getProductsCount() = productsCount

}