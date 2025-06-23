package com.example.houseedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.houseedge.ui.theme.HouseEdgeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset
import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults


class SessionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountScreen()
        }
    }
}

@Composable
fun CountScreen() {
    var count by remember { mutableIntStateOf(0) }
    var handCount by remember { mutableIntStateOf(0) }
    var wager = 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFF50202),
                        Color(0xFFBD4747),
                        Color(0xFF6C6060),
                        Color(0xFF516B96),
                        Color(0xFF008ADF)
                    ),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
            .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display for the Hand, Wager, and Count
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Hand Count Box
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .border(3.dp, Color.Black)
                    .padding(16.dp)
            ) {
                Text(text = "Hand: $handCount", fontSize = 18.sp)
            }
            // Wager Box
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .border(3.dp, Color.Black)
                    .padding(16.dp)
            ) {
                Text(text = "Wager: $${String.format("%.2f", wager)}", fontSize = 18.sp)
            }
            // Count Box
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .border(3.dp, Color.Black)
                    .padding(16.dp)
            ) {
                Text(text = "Count: $count", fontSize = 18.sp)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // +1 Button
                OutlinedButton(
                    onClick = {
                        count += 1

                    },
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .padding(8.dp),
                    border = BorderStroke(4.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF444444)
                    )
                ) {
                    Text(text = "+1", fontSize = 64.sp)
                }
                // 0 Button
                OutlinedButton(
                    onClick = {
//                        handCount += 1
                    },
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .padding(8.dp),
                    border = BorderStroke(4.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF444444)
                    )
                ) {
                    Text(text = "0", fontSize = 64.sp)
                }
                // -1 Button
                OutlinedButton(
                    onClick = {
                        count -= 1
//                        handCount += 1
                    },
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .padding(8.dp),
                    border = BorderStroke(4.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF444444)
                    )
                ) {
                    Text(text = "-1", fontSize = 64.sp)
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun CountScreenPreview() {
    CountScreen()
}
