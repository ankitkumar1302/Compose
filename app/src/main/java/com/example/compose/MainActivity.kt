package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SuperscriptSpanText(normalText = "Hello", superText = "Hello World")

                }
            }
        }
    }
}

@Composable
fun TextCustomization() {
    ComposeTheme() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                // use of string resource to call the string name in our project we cant directly call the string
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    // If we write .background() up the padding it will color the whole area of the text acquire.
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
                    .width(200.dp),
                color = Color.White,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
                // If we write .background() bellow the padding it it will color the text area only.
                // Form top to bottom it will execute.
            )
        }
    } // Here the text writen and how to customize it.
}

@Composable
fun CustomText2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Magenta,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("A")
                    }
                    append("B")
                    append("C")
                    append("D")
                }
            }, modifier = Modifier.width(200.dp)
        )
    } // Here it have Customize the letter/Alphabet/Text.
}

@Composable
fun CustomText() {
    Text(text = "Hey Ankit!".repeat(20), maxLines = 2, overflow = TextOverflow.Visible)
} // Here it has repeat lines function.

/*
// Created a customItem function
@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color = MaterialTheme.colorScheme.secondary) {
    // To use the weight function we need to call a extension function (ColumnScope).
    Surface(
        // Don't use column here because it combine the different surface to each other.
        // We Don't use column as a parent of surface
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    ComposeTheme {
        Column(
            // Used for vertical arrangement
            modifier = Modifier.height(500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {

            CustomItem(weight = 3f, MaterialTheme.colorScheme.primary)
            CustomItem(weight = 1f)
            // Default value has been assigned... in the CustomItem
        }
        // This For Row...
        // Now it was added by git to a new branch Known as Row.
    }
}
@Composable
fun RowScope.CustomItem1(weight: Float, color: Color = MaterialTheme.colorScheme.secondary) {
    // To use the weight function we need to call a extension function (RowScope).
    Surface(
        // Give the width and height to show the Row
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .weight(weight),
        color = color
    ) {}
}
@Preview(showBackground = true)
@Composable
fun Row() {
    ComposeTheme {
         Row(
            // Used for Horizontal arrangement
            modifier = Modifier
                .height(250.dp)
                .width(250.dp),
            horizontalArrangement = Arrangement.SpaceBetween
         , verticalAlignment = Alignment.CenterVertically
        ) {
            CustomItem1(weight = 3f, MaterialTheme.colorScheme.primary)
            CustomItem1(weight = 1f)
            // Default value has been assigned... in the CustomItem
        }
    }
*/
@Composable
fun CustomText1() {
    SelectionContainer() {
        Column {
            Text(text = "Hello, World!", modifier = Modifier.padding(10.dp))
            DisableSelection {
                Text(text = "Hello, World!")
            }
            Text(text = "Hello, World!")
        }
    }
} // It has Selection and deselection of words.
@Composable
fun SuperscriptSpanText(
    normalText: String,
    superText: String
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript
            )
        ) {
            append(superText)
        }
    })

}
