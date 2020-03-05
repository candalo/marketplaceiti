package com.github.candalo.marketplaceiti.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.github.candalo.marketplaceiti.views.ProductDetailsView

@RegisterWidget
data class ProductDetailsWidget(
    val productWidget: ProductWidget,
    val productControlWidget: ProductControlWidget
) : WidgetView() {

    override fun toView(context: Context): View =
        ProductDetailsView(context).apply {
            setId(this@ProductDetailsWidget.id ?: "")
            setProductName(productWidget.title)
            setProductNameColor(productWidget.titleColor)
            setProductNameSize(productWidget.titleSize.toFloat())
            setProductDescription(productWidget.subtitle)
            setProductDescriptionColor(productWidget.subtitleColor)
            setProductDescriptionSize(productWidget.subtitleSize.toFloat())
            setProductValue(productWidget.value)
            setProductValueColor(productWidget.valueColor)
            setProductValueSize(productWidget.valueSize.toFloat())
            setImage(productWidget.imageUrl)
            getProductsControlView().setButtonsColor(productControlWidget.controlColor)
        }

}