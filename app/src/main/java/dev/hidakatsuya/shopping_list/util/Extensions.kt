package dev.hidakatsuya.shopping_list.util

import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import dev.hidakatsuya.shopping_list.R

fun Toolbar.displayBackButtonAsCloseIcon() {
    navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_close)
}