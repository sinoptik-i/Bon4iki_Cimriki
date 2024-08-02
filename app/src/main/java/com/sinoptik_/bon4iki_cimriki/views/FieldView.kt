package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinoptik_.bon4iki_cimriki.viewModels.FieldViewModel


@Composable
fun FieldView(
    fieldViewModel: FieldViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Card(
            modifier = Modifier
                .size(240.dp),

            ) {
            val itemsList = (0..8).toList()
            LazyHorizontalGrid(
                rows = GridCells.Fixed(3),
                modifier = Modifier.size(240.dp)//.fillMaxSize()
            ) {
                items(itemsList) { item ->
                    val position = Pair(item / 3, item % 3)
                    CellView(
                        cellState = fieldViewModel.getCellByPosition(position)
                    ) { fieldViewModel.onCellClick(position) }
                }
            }
        }
    }
}

@Preview
@Composable
fun FieldViewPreview(
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Card(
            modifier = Modifier.size(240.dp)
        ) {


            val itemsList = (0..8).toList()
            LazyHorizontalGrid(
                rows = GridCells.Fixed(3),
                modifier = Modifier.size(240.dp)//.fillMaxSize()
            ) {
                items(itemsList) { item ->
                    CellViewPreview()
                }
            }
        }
    }
}