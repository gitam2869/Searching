package com.app.searching

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class KeyboardUtility {

    companion object {

        //open keyboard
         fun openKeyboard(view : View) {
            view.requestFocus()
            view.setFocusableInTouchMode(true)
            view.isFocusable = true
            val imgr =
                App.applicationContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }


        fun hideKeyboardForcely() {
            val imm = App.applicationContext().getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager

            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
        }

        //hide keyboard
        fun hideKeyboard(currentFocus: View) {
            val imm =
                App.applicationContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        }
    }
}
