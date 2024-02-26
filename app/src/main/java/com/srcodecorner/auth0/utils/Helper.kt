package com.srcodecorner.auth0.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.util.regex.Pattern

object Helper {
   val EMAIL_ADDRESS_PATTERN = Pattern.compile(
       "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
               "\\@" +
               "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
               "(" +
               "\\." +
               "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
               ")+"
   );

    fun showToast(context: Context, message:String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
     fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }
}