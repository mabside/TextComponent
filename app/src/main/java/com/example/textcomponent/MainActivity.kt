package com.example.textcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.textcomponent.ui.theme.TextComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun normalText() {
    Text(
        text = "Hello from Compose",
        fontSize = 18.sp, maxLines = 1,
        color = Color.Blue
    )
}

@Composable
fun textWithTextStyle(){
    val h1 = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 42.sp
    )
    Text(text = "Sample Big header text style", style = h1)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextComponentTheme {
        Text(text = "My Sample Large header", style = MaterialTheme.typography.headlineLarge)
    }
}