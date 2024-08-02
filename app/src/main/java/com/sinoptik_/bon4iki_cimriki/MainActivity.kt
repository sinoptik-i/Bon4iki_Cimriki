package com.sinoptik_.bon4iki_cimriki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sinoptik_.bon4iki_cimriki.ui.theme.Bon4iki_CimrikiTheme
import com.sinoptik_.bon4iki_cimriki.viewModels.FieldViewModel
import com.sinoptik_.bon4iki_cimriki.views.MainScreen
import com.sinoptik_.bon4iki_cimriki.views.MessageView

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val fieldViewModel: FieldViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bon4iki_CimrikiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (fieldViewModel.messageTime.value) {


                        MessageView(
                            fieldViewModel.currentMessage,
                            { fieldViewModel.messageViewCancel() })
                    } else {
                        MainScreen(fieldViewModel)
                    }

                }
            }
        }
    }
}
