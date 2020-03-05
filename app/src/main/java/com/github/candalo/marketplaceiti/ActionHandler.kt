package com.github.candalo.marketplaceiti

import android.content.Context
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.action.CustomActionHandler
import br.com.zup.beagle.annotation.BeagleComponent

@BeagleComponent
class ActionHandler : CustomActionHandler {

    override fun handle(context: Context, action: CustomAction) {
        (context as MainActivity).openFragment(CartProductsFragment(), true)
    }

}