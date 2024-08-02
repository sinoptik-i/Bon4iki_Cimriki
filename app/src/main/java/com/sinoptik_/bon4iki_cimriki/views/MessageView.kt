package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun MessageView(
    text: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .clickable {
                onClick()
            },
    ) {
        Text(
            text = text,
            fontSize = 15.em,
            textAlign = TextAlign.Center,
            style = TextStyle(textIndent = TextIndent(0.sp, 15.sp))

        )
    }
}

@Preview
@Composable
fun TimeToTapPreview() {
    MessageView(
        "Всё! Хватит! Пора потапать хомяка!",
        {})
}