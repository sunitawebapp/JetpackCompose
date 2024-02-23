package com.srcodecorner.auth0.components

import android.util.Log
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        textAlign = TextAlign.Center
    )

}

@Composable
fun SpacerComponent(size: Int) {
    Spacer(modifier = Modifier.size(size.dp))
}

@Composable
fun TextFieldComponent(labelValue: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        placeholder =  { Text(text = labelValue) },
        onValueChange = {
                        text= it
        },
        modifier = Modifier.fillMaxWidth(),
        )

}



@Composable
fun ButtonComponent(value: String, onclick: ()-> Unit) {
    Button(onclick, modifier = Modifier.fillMaxWidth()) {
        Text(text = value)
    }
}