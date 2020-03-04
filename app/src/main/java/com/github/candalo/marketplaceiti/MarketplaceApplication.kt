package com.github.candalo.marketplaceiti

import android.app.Application

class MarketplaceApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}