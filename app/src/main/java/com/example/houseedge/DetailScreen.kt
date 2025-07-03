package com.example.houseedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DetailScreen(navController: NavController, modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterStart,
    ){
        Column {
            var filledText by remember{
                mutableStateOf("")
            }
            TextField(
                value = filledText,
                onValueChange = {filledText = it},
                placeholder = {
                    Text(text = "Dealer Name")
                },
                supportingText = {
                    Text(text = "*required")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType =  KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                    },
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = filledText,
                onValueChange = {filledText = it},
                placeholder = {
                    Text(text = "Table Number")
                },
                supportingText = {
                    Text(text = "*required")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType =  KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                    },
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = filledText,
                onValueChange = {filledText = it},
                placeholder = {
                    Text(text = "Seat Number")
                },
                supportingText = {
                    Text(text = "*required")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType =  KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                    },
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = filledText,
                onValueChange = {filledText = it},
                placeholder = {
                    Text(text = "Number of Decks")
                },
                supportingText = {
                    Text(text = "*required")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType =  KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                    },
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = filledText,
                onValueChange = {filledText = it},
                placeholder = {
                    Text(text = "Count Method")
                },
                supportingText = {
                    Text(text = "*required")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType =  KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                    },
                )
            )

            Button(
                onClick = { /*TODO*/ },
                enabled = true,
                shape = ButtonDefaults.shape,
                border = BorderStroke(2.dp, color = Color.White),
                modifier = Modifier
                    .size(400.dp, 150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6C6060),
                    contentColor = Color.Black,

                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                ) {
                    Text(
                        text = "START ",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "COUNT",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}