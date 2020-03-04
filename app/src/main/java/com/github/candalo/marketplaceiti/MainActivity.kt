package com.github.candalo.marketplaceiti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(ProductsFragment())
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also {
            it.replace(R.id.fragment_container, fragment)
            it.commit()
        }
    }

}