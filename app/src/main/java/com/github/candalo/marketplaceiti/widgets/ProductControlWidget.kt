package com.github.candalo.marketplaceiti.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.github.candalo.marketplaceiti.views.ProductControlView

@RegisterWidget
data class ProductControlWidget(
    val productWidget: ProductWidget,
    val controlColor: String
) : WidgetView() {

    override fun toView(context: Context): View =
        ProductControlView(context).apply {
            setButtonsColor(controlColor)
        }

}