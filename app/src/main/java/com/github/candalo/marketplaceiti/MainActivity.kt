package com.github.candalo.marketplaceiti

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ServerDrivenState
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

@BeagleComponent
class MainActivity : BeagleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(ProductsFragment())
    }

    fun openFragment(fragment: Fragment, isToAddToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().also {
            it.replace(R.id.fragment_container, fragment)
            if (isToAddToBackStack) it.addToBackStack(null)
            it.commit()
        }
    }

    override fun getServerDrivenContainerId(): Int = R.id.fragment_container

    override fun getToolbar(): Toolbar = toolbar

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
//        if (state is ServerDrivenState.Loading) {
//            progressBar.visibility = if (state.loading) View.VISIBLE else View.GONE
//        } else if (state is ServerDrivenState.Error) {
//            Snackbar.make(window.decorView, "Error", Snackbar.LENGTH_LONG).show()
//        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }
}