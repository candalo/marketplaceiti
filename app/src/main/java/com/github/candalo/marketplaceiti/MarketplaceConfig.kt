package com.github.candalo.marketplaceiti

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.BeagleConfig
import br.com.zup.beagle.setup.Environment

@BeagleComponent
class MarketplaceConfig : BeagleConfig {
    override val baseUrl: String get() = "http://10.0.2.2:8080/"
    override val environment: Environment get() = Environment.DEBUG
}