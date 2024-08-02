package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ButtonRow(
    text: String,
    onButtonClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(
                    2.dp,
                    Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            )
        //  .height(60.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            onClick = onButtonClicked
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(1f),
                textAlign = TextAlign.Center,
                text = text
            )
        }
    }
}