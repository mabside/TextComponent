package com.example.textcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.PluralsRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        BaseLineText()
    }
}

@Composable
fun quantityStringResource(@PluralsRes pluralResId: Int, quantity: Int, vararg formatArgs: Any? = emptyArray()): String
{
    return LocalContext.current.resources.getQuantityString(pluralResId, quantity, *formatArgs)
}

@Composable
fun TextWithQuantity(){
    Column {
        Text(quantityStringResource(pluralResId = R.plurals.contact, quantity = 0,0))
        Text(quantityStringResource(pluralResId = R.plurals.contact, quantity = 1,1))
        Text(quantityStringResource(pluralResId = R.plurals.contact, quantity = 2,2))
        Text(quantityStringResource(pluralResId = R.plurals.contact, quantity = 3,3))
        Text(quantityStringResource(pluralResId = R.plurals.contact, quantity = 10,10))
    }
}

@Composable
fun ClickableText(){
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Search")
    }
}

@Composable
fun UrlSpanText(){
    val tag = "info"
    val annotatedString = buildAnnotatedString {
        val text = "For more info click here"
        append(text)

        val start = text.indexOf("here")
        val end = start + 4

        addStyle(
            style =  SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            ),
            start = start,
            end = end
        )

        addStringAnnotation(
            tag = tag,
            annotation = "https://google.com",
            start = start,
            end = end
        )
    }

    val uriHandler = LocalUriHandler.current

    androidx.compose.foundation.text.ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString
            .getStringAnnotations(tag, offset, offset)
            .firstOrNull()
            ?.let { string ->
                uriHandler.openUri(string.item)
            }
    })
}

/*
Padding the text content with the main view
 */
@Composable
fun BaseLineText(){
    Text(
        text = "Choose an account",
        modifier = Modifier.padding(top = 40.dp),
        style = MaterialTheme.typography.labelSmall
    )
}
