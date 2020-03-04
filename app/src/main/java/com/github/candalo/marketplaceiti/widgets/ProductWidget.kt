package com.github.candalo.marketplaceiti.widgets

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.bumptech.glide.Glide
import com.github.candalo.marketplaceiti.R

@RegisterWidget
data class ProductWidget(
    val title: String,
    val titleColor: String,
    val titleSize: Int,
    val subtitle: String,
    val subtitleColor: String,
    val subtitleSize: Int,
    val imageUrl: String,
    val value: String,
    val valueColor: String,
    val valueSize: Int
) : WidgetView() {

    override fun toView(context: Context): View {
        val view = LayoutInflater.from(context).inflate(R.layout.widget_product, null)
        val titleTextView = view.findViewById<TextView>(R.id.productTitle)
        val subtitleTextView = view.findViewById<TextView>(R.id.productSubtitle)
        val imageImageView = view.findViewById<ImageView>(R.id.productImage)
        val valueTextView = view.findViewById<TextView>(R.id.productValue)

        loadImage(context, imageImageView)
        setTextStyle(context, titleTextView, title, titleColor, titleSize)
        setTextStyle(context, subtitleTextView, subtitle, subtitleColor, subtitleSize)
        setTextStyle(context, valueTextView, value, valueColor, valueSize)

        return view
    }

    private fun setTextStyle(context: Context, textView: TextView, text: String, textColor: String, textSize: Int) {
        textView.let {
            it.text = text
            it.setTextColor(Color.parseColor(textColor))
            it.textSize = textSize.toFloat()
        }
    }

    private fun loadImage(context: Context, imageView: ImageView) {
        Glide.with(context).load(imageUrl).into(imageView)
    }
}