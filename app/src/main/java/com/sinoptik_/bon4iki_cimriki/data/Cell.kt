package com.sinoptik_.bon4iki_cimriki.data

import androidx.compose.runtime.mutableStateOf
import com.sinoptik_.bon4iki_cimriki.R

class Cell {
    var state= mutableStateOf(CellState.EMPTY)
}

// orig
enum class CellState(val pictureName: Int) {
    Cimrik(R.drawable.cimrik),
    Bon4ik(R.drawable.bon4ik),
    EMPTY(R.drawable.empty);

     fun getValue(): Int {
        return pictureName
    }
}


/*

enum class CellState(val pictureName: String) {
    CIMRIK("C"),
    BON4IK("B"),
    EMPTY("E");

    override fun toString(): String {
        return pictureName
    }
}*/
