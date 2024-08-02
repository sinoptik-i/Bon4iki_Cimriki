package com.sinoptik_.bon4iki_cimriki.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sinoptik_.bon4iki_cimriki.data.Game
import com.sinoptik_.bon4iki_cimriki.data.MoveResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FieldViewModel @Inject constructor() : ViewModel() {
    private val TAG = this.javaClass.simpleName
    private val game = Game()
    val text = mutableStateOf("")
    private var gameInProcess = true

    private var countOfWins = 0
    val messageTime = mutableStateOf(false)
    fun messageViewCancel() {
        messageTime.value = false
    }

    var currentMessage = ""

    private val timeToTapText = "Всё! Хватит! Пора потапать хомяка!"
    private val buyBeerToDeveloper = "Задонатьте Стасяну на пивас!"

    fun getCellByPosition(position: Pair<Int, Int>) = game.getCellByPosition(position)
    fun reStart() {
        if (countOfWins % 3 == 0) {
            currentMessage = timeToTapText
            messageTime.value = true
        } else if (countOfWins % 2 == 0) {
            currentMessage = buyBeerToDeveloper
            messageTime.value = true
        }
        gameInProcess = true
        game.reStart()
    }

    fun onCellClick(position: Pair<Int, Int>) {
        if (gameInProcess) {
            val result = game.move(position)
            Log.e(TAG, "result $result")

            when (result) {
                MoveResult.WIN -> {
                    text.value = "Winner ${game.getCurrentPlayer()}"
                    gameInProcess = false
                    countOfWins++

                }

                MoveResult.DRAW -> text.value = "Вы блять конченые"
                else -> {}
            }
        }

    }


}

