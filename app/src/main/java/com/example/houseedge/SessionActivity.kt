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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset


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
    var count by remember { mutableStateOf(0) }
    var handCount by remember { mutableStateOf(0) }
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
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display for the Hand, Wager, and Count
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Hand: $handCount", fontSize = 18.sp)
            Text(text = "Wager: $${String.format("%.2f", wager)}", fontSize = 18.sp)
            Text(text = "Count: $count", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountScreenPreview() {
    CountScreen()
    }
