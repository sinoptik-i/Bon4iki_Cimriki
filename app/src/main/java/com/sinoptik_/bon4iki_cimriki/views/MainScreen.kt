package com.sinoptik_.bon4iki_cimriki.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sinoptik_.bon4iki_cimriki.viewModels.FieldViewModel

@Composable
fun MainScreen(
    fieldViewModel: FieldViewModel
) {

    Column {
        TextRow(text = fieldViewModel.text)
        ButtonRow(text = "Restart") {
            fieldViewModel.reStart()
        }
        FieldView(fieldViewModel = fieldViewModel)
       // TextRow(text = "")
    }
}

@Preview
@Composable
fun MainScreenPreview(
) {

    Column {
        TextRowPreview()
        Box {
            FieldViewPreview()
        }
        TextRowPreview()
    }
}