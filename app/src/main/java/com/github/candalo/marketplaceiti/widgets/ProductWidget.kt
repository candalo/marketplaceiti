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
import com.github.candalo.marketplaceiti.views.ProductView

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

    override fun toView(context: Context): View =
        ProductView(context).apply {
            setId(this@ProductWidget.id ?: "")
            setTitle(title)
            setTitleColor(titleColor)
            setTitleSize(titleSize.toFloat())
            setSubTitle(subtitle)
            setSubTitleColor(subtitleColor)
            setSubTitleSize(subtitleSize.toFloat())
            setValue(value)
            setValueColor(valueColor)
            setValueSize(valueSize.toFloat())
            setImage(imageUrl)
        }

}