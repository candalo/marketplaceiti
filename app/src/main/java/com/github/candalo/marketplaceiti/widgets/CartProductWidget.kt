package com.github.candalo.marketplaceiti.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.github.candalo.marketplaceiti.views.CartProductView

@RegisterWidget
data class CartProductWidget(
    val imageUrl: String,
    val productName: String,
    val productNameColor: String,
    val productNameSize: Int,
    val productPrice: String,
    val productPriceColor: String,
    val productPriceSize: Int
) : WidgetView() {

    override fun toView(context: Context): View =
        CartProductView(context).apply {
            setId(this@CartProductWidget.id ?: "")
            setProductName(productName)
            setProductNameColor(productNameColor)
            setProductNameSize(productNameSize.toFloat())
            setProductValue(productPrice)
            setProductValueColor(productPriceColor)
            setProductValueSize(productPriceSize.toFloat())
            setImage(imageUrl)
        }

}