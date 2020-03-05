package com.github.candalo.marketplaceiti.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.candalo.marketplaceiti.R

class ProductDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private lateinit var id: String
    private val productImage: ImageView
    private val productName: TextView
    private val productValue: TextView
    private val productDescription: TextView
    private val productControlView: ProductControlView

    init {
       LayoutInflater.from(context).inflate(R.layout.view_product_details, this, true).also {
           productImage = findViewById(R.id.productImage)
           productName = findViewById(R.id.productName)
           productValue = findViewById(R.id.productValue)
           productDescription = findViewById(R.id.productDescription)
           productControlView = ProductControlView(context, attrs, defStyle)
       }
    }

    fun setId(id: String) {
        this.id = id
    }

    fun setProductName(text: String) {
        productName.text = text
    }

    fun setProductNameColor(hexColor: String) {
        productName.setTextColor(Color.parseColor(hexColor))
    }

    fun setProductNameSize(size: Float) {
        productName.textSize = size
    }

    fun setProductDescription(text: String) {
        productDescription.text = text
    }

    fun setProductDescriptionColor(hexColor: String) {
        productDescription.setTextColor(Color.parseColor(hexColor))
    }

    fun setProductDescriptionSize(size: Float) {
        productDescription.textSize = size
    }

    fun setProductValue(text: String) {
        productValue.text = text
    }

    fun setProductValueColor(hexColor: String) {
        productValue.setTextColor(Color.parseColor(hexColor))
    }

    fun setProductValueSize(size: Float) {
        productValue.textSize = size
    }

    fun setImage(imageUrl: String) {
        Glide.with(context).load(imageUrl).apply(RequestOptions().error(R.drawable.default_image)).into(productImage)
    }

    fun getProductsControlView() = productControlView

}