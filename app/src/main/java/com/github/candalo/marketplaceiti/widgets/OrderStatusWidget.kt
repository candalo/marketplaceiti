package com.github.candalo.marketplaceiti.widgets

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.github.candalo.marketplaceiti.R

@RegisterWidget
data class OrderStatusWidget(
    val state: State,
    val orderStatusTitle: String,
    val orderStatusTitleColor: String,
    val orderStatusMessage: String,
    val orderStatusMessageColor: String
) : WidgetView() {

    override fun toView(context: Context): View {
        val view = LayoutInflater.from(context).inflate(R.layout.widget_order_status, null)
        val orderStatusImageView = view.findViewById<ImageView>(R.id.orderStatusImage)
        val orderStatusTitleTextView = view.findViewById<TextView>(R.id.orderStatusTitle)
        val orderStatusMessageTextView = view.findViewById<TextView>(R.id.orderStatusMessage)


        setImageStyle(context, orderStatusImageView, state)
        setTextStyle(orderStatusTitleTextView, orderStatusTitle, orderStatusTitleColor)
        setTextStyle(orderStatusMessageTextView, orderStatusMessage, orderStatusMessageColor)

        return view
    }

    private fun setTextStyle(textView: TextView, text: String, textColor: String) {
        textView.let {
            it.text = text
            it.setTextColor(Color.parseColor(textColor))
        }
    }

    private fun setImageStyle(context: Context, imageView: ImageView, state: State) {
        when (state) {
            State.Success -> imageView.setImageDrawable(context.getDrawable(R.drawable.order_successfully))
            State.Error -> imageView.setImageDrawable(context.getDrawable(R.drawable.order_error))
        }
    }

    enum class State {
        Success, Error
    }

}