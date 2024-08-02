package com.sinoptik_.bon4iki_cimriki.data

import androidx.compose.runtime.mutableStateOf

class Field(val size: Int = 3) {

    var field = arrayOf<Array<Cell>>()

    init {
        field = emptyArray()
        repeat(size) {
            var str = arrayOf<Cell>()
            repeat(size) {
                str += Cell()
            }
            field += str
        }
    }

    fun reStart() {
        repeat(size) { strCount ->
            repeat(size) { columnCount ->
                field[strCount][columnCount].state.value = CellState.EMPTY
            }
        }
    }

    fun move(
        player: CellState,
        position: Pair<Int, Int>
    ): MoveResult {
        return if (field[position.first][position.second].state.value
            == CellState.EMPTY
        ) {
            field[position.first][position.second].state.value = player
            if (checkWin(position)) {
                MoveResult.WIN
            } else {
                MoveResult.NO_WIN
            }
        } else {
            MoveResult.WRONG_MOVE
        }

    }

    private fun checkWin(position: Pair<Int, Int>): Boolean {
        var result = false
        val player = field[position.first][position.second]

        //string
        result = true
        repeat(size) {
            if (field[position.first][it].state.value != player.state.value) {
                result = false
            }
        }
        if (result) {
            return result
        }

        //column
        result = true
        repeat(size) {
            if (field[it][position.second].state.value != player.state.value) {
                result = false
            }
        }
        if (result) {
            return result
        }

        //topleft-botright
        if (position.first == position.second) {
            result = true
            repeat(size) {
                if (field[it][it].state.value != player.state.value) {
                    result = false
                }
            }
        }
        if (result) {
            return result
        }

        //botleft-topright
        if (position.first + position.second == (size - 1)) {
            result = true
            repeat(size) {
                if (field[size - it - 1][it].state.value != player.state.value) {
                    result = false
                }
            }
        }

        return result
    }
}