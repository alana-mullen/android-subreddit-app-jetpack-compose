package co.uk.thewirelessguy.androidsubredditcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val listItemTitleTextColor: Color
    @Composable get() = if (isSystemInDarkTheme()) Color.White else Color.Black

val listItemSubTitleTextColor: Color
    @Composable get() = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray