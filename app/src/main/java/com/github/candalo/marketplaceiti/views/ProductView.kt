package com.github.candalo.marketplaceiti.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.candalo.marketplaceiti.MainActivity
import com.github.candalo.marketplaceiti.ProductDetailFragment
import com.github.candalo.marketplaceiti.R

class ProductView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle) {

    private lateinit var id: String
    private lateinit var sku: String
    private val titleTextView: TextView
    private val subtitleTextView: TextView
    private val valueTextView: TextView
    private val imageImageView: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_product, this, true).also {
            titleTextView = it.findViewById(R.id.productTitle)
            subtitleTextView = it.findViewById(R.id.productSubtitle)
            valueTextView = it.findViewById(R.id.productValue)
            imageImageView = it.findViewById(R.id.productImage)
            isClickable = true
            isFocusable = true
            setOnClickListener {
                (context as MainActivity).openFragment(ProductDetailFragment.newInstance(sku), true)
            }
        }
    }

    fun setId(id: String) {
        this.id = id
    }

    fun setSku(sku: String) {
        this.sku = sku
    }

    fun setTitle(text: String) {
        titleTextView.text = text
    }

    fun setTitleColor(hexColor: String) {
        titleTextView.setTextColor(Color.parseColor(hexColor))
    }

    fun setTitleSize(size: Float) {
        titleTextView.textSize = size
    }

    fun setSubTitle(text: String) {
        subtitleTextView.text = text
    }

    fun setSubTitleColor(hexColor: String) {
        subtitleTextView.setTextColor(Color.parseColor(hexColor))
    }

    fun setSubTitleSize(size: Float) {
        subtitleTextView.textSize = size
    }

    fun setValue(text: String) {
        valueTextView.text = text
    }

    fun setValueColor(hexColor: String) {
        valueTextView.setTextColor(Color.parseColor(hexColor))
    }

    fun setValueSize(size: Float) {
        valueTextView.textSize = size
    }

    fun setImage(imageUrl: String) {
        Glide.with(context).load(imageUrl).apply(RequestOptions().error(R.drawable.default_image)).into(imageImageView)
    }

}