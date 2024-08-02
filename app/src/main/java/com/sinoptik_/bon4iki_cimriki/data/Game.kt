package com.sinoptik_.bon4iki_cimriki.data

import android.util.Log
import kotlin.random.Random

enum class MoveResult {
    WIN,
    NO_WIN,
    WRONG_MOVE,
    DRAW //ничья
}


class Game {
    private val TAG = this.javaClass.simpleName

    private lateinit var players: Array<CellState>
    private var moveCount = 0
    private val field = Field()

    init {
        reStart()
    }

    fun getPlayers() = players
    fun getCurrentPlayer() = players[moveCount % 2]

    fun getCellByPosition(position: Pair<Int, Int>) =
        field.field[position.first][position.second].state

    fun reStart() {
        val rand = Random.nextInt(0, 2)
        players = arrayOf(
            CellState.entries[rand],
            CellState.entries[(rand + 1) % 2]
        )
        moveCount = 0
        field.reStart()
    }

    fun move(position: Pair<Int, Int>): MoveResult {
        Log.e(TAG, "moveCount $moveCount")



        val result = field.move(
            players[moveCount % 2],
            position
        )

        if (result == MoveResult.NO_WIN) {
            moveCount++
            if (moveCount == 9) {
                return MoveResult.DRAW
            }
        }
        return result
    }
}
