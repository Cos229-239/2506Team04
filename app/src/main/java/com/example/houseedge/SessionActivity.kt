package com.example.houseedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.launch


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
fun WinLossMenu(onResult: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(Color.DarkGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        listOf("Win", "Loss", "Push").forEach { label ->
            OutlinedButton(
                onClick = onResult,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp)
                    .padding(8.dp),
                border = BorderStroke(4.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF444444)
                )
            ) {
                Text(label, fontSize = 64.sp)
            }
        }
    }
}

@Composable
fun CountButtons(label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(8.dp),
        border = BorderStroke(4.dp, Color.White),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            containerColor = Color(0xFF444444)
        )
    ) {
        Text(label, fontSize = 64.sp)
    }
}

@Composable
fun CountScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var count by remember { mutableIntStateOf(0) }
    var handCount by remember { mutableIntStateOf(0) }
    var wager = 0.0

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            WinLossMenu {
                handCount += 1
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        if (dragAmount < 50) { // Positive indicates right swipe
                            scope.launch { drawerState.open() }
                        }
                    }
                }
        ) {

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
                    // Count Buttons to update the Count within the app screen
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally) {
                            CountButtons("+1") { count += 1 }
                            CountButtons("0") { }
                            CountButtons("-1") { count -= 1 }
                    }
                }
            }
        }
    }
}