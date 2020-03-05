package com.github.candalo.marketplaceiti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.view.ScreenRequest
import kotlinx.android.synthetic.main.fragment_cart_products.*

class CartProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cart_products, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainContent.loadView(this, ScreenRequest("/cart/products"))
    }

}