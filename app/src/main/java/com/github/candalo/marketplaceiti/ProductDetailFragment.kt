package com.github.candalo.marketplaceiti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import com.github.candalo.marketplaceiti.views.ProductView
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_product_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(ProductView::javaClass.name)
        mainContent.loadView(context as BeagleActivity, ScreenRequest("/products/${id}"))
    }

    companion object {
        fun newInstance(id: String) =
            ProductDetailFragment().apply {
                val bundle = Bundle().apply {
                    putString(ProductView::javaClass.name, id)
                }
                arguments = bundle
            }
    }

}