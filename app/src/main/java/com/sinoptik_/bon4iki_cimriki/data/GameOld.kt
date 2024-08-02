/*
package com.sinoptik_.bon4iki_cimriki.data

import kotlin.random.Random

class Game {

    private lateinit var players: Array<CellState>
    private var moveCount = 0
    private val field = Field()

    init {
        reStart()
    }

    private fun reStart() {
        val rand = Random.nextInt(0, 2)
        players = arrayOf(
            CellState.entries[rand],
            CellState.entries[(rand + 1) % 2]
        )
        moveCount = 0
        steps1()
    }


    fun start() {
        println("player1: ${players[0].pictureName}")
        println("player2: ${players[1].pictureName}")

        field.printField()
        while (moveCount < 9) {
            val res = field.move(
                players[moveCount % 2],
                steps[moveCount]
                //takePosition()
            )
            printStep()
            println()
            if (res) {
                println("player: ${players[moveCount % 2].pictureName} Win!")
                moveCount = 9
            }
            moveCount++
        }

    }

    private fun printStep() {
        println("Step №$moveCount")
        println("player${(moveCount % 2) + 1}'s step:")
        field.printField()
    }


    private fun takePosition(): Pair<Int, Int> {
        return readln().split(' ')
            .map {
                it.toInt()
            }
            .let {
                Pair(it[0], it[1])
            }
    }

    private lateinit var steps: Array<Pair<Int, Int>>
    private fun steps1() {
        steps = arrayOf(
            Pair(0, 0),
            Pair(2, 2),
            Pair(2, 0),
            Pair(1, 0),
            Pair(0, 2),
            Pair(0, 1),
            Pair(1, 1)
        )
    }


}*/
