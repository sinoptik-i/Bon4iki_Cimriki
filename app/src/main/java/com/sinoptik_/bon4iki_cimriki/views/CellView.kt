package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinoptik_.bon4iki_cimriki.data.CellState

@Composable
fun CellView(
    cellState: MutableState<CellState>,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .border(
            width = 1.dp,
            color = Color.Black
        )
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(
                cellState.value.pictureName
            ),
            "",
            modifier = Modifier
                .background(color = Color.White)
                .clip(
                    shape = RoundedCornerShape(100)// RoundedCornerShape(25.dp)
                )
                .clickable {
                    onClick()
                }
                .size(80.dp)
        )
    }
}


@Preview
@Composable
fun CellViewPreview() {
    val cell = remember {
        mutableStateOf(CellState.Bon4ik)
    }

    CellView(
        cellState = cell
    ) {
        cell.value = CellState.Cimrik
    }
}


/*@Composable
fun UnderCell(
    fieldViewModel: FieldViewModel// = hiltViewModel()
) {
    CellView(
        cellState = fieldViewModel.field.field[0][0].state
    ) { fieldViewModel.onCellClick(Pair(0,0)) }

    *//*CellView(
        cellState = fieldViewModel.cellState
    ) { fieldViewModel.changeState() }*//*
}*/

/*
@Composable
fun CellView(
    cell: Cell,
    onClick: () -> Unit,
    fieldViewModel: FieldViewModel// = hiltViewModel()
) {
    //val cellState by fieldViewModel.oneCellFlow().collectAsState()

    val cellState = remember {
        //mutableStateOf(CellState.O)
        fieldViewModel.cellState
    }

    Card(
        modifier = Modifier.border(
            width = 1.dp,
            color = Color.Black
        )

    ) {
        Image(
            bitmap = ImageBitmap.imageResource(
                cellState.value.pictureName
//                        cellState.pictureName
            ),
            "",
            modifier = Modifier
                .clickable {
                   // cellState.value=CellState.X
                    fieldViewModel.changeState()
                    //onClick()
                }
                .size(80.dp)
            //.fillMaxSize()
        )
    }
}*/
