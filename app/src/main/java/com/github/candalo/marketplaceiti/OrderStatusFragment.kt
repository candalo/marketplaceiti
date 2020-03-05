package com.github.candalo.marketplaceiti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.view.ScreenRequest
import com.github.candalo.marketplaceiti.widgets.OrderStatusWidget
import kotlinx.android.synthetic.main.fragment_order_status.*

class OrderStatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_order_status, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val status = arguments?.getString(OrderStatusWidget.State::javaClass.name)
        mainContent.loadView(this, ScreenRequest("products/orders/status?state=${status}"))
    }

    companion object {
        fun newInstance(state: OrderStatusWidget.State) =
            OrderStatusFragment().apply {
                val bundle = Bundle().apply {
                    putString(OrderStatusWidget.State::javaClass.name, state.name.toLowerCase())
                }
                arguments = bundle
            }
    }

}