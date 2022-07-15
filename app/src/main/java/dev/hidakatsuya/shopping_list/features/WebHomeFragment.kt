package dev.hidakatsuya.shopping_list.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.hidakatsuya.shopping_list.R
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web/home")
class WebHomeFragment : WebFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_home, container, false)
    }

    override fun shouldObserveTitleChanges(): Boolean {
        return false
    }
}