package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextRow(
    text: MutableState<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = text.value,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun TextRowPreview() {
    TextRow(text = remember {
        mutableStateOf("TextRow!")
    })
}