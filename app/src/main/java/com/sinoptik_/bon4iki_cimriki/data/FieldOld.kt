package com.sinoptik_.bon4iki_cimriki.data

class FieldOld(val size: Int = 3) {

    var field = arrayOf<Array<CellState>>()

    init {
        reStart()
    }

    fun reStart() {
        field = emptyArray()
        repeat(size) {
            var str = arrayOf<CellState>()
            repeat(size) {
                str += CellState.EMPTY
            }
            field += str
        }
    }

    fun move(
        player: CellState,
        position: Pair<Int, Int>
    ): Boolean {
        if (field[position.first][position.second]
            == CellState.EMPTY
        ) {
            field[position.first][position.second] = player
        }
        return checkWin(position)
    }

    private fun checkWin(position: Pair<Int, Int>): Boolean {
        var result = false
        val player = field[position.first][position.second]

        //string
        result = true
        repeat(size) {
            if (field[position.first][it] != player) {
                result = false
            }
        }

        //column
        result = true
        repeat(size) {
            if (field[it][position.second] != player) {
                result = false
            }
        }

        //topleft-botright
        if (position.first == position.second) {
            result = true
            repeat(size) {
                if (field[it][it] != player) {
                    result = false
                }
            }
        }

        //botleft-topright
        if (position.first + position.second == (size - 1)) {
            result = true
            repeat(size) {
                if (field[size - it - 1][it] != player) {
                    result = false
                }
            }
        }

        return result
    }
}