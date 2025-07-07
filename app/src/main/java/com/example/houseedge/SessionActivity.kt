package com.example.houseedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
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

// Design function for the buttons to update the count
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

// Number pad within the wager popup menu
@Composable
fun NumberPad(input: String, onInputChanged: (String) -> Unit, onApply: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = input.ifEmpty { "0" },
            fontSize = 38.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Button list for the number pad
        val buttonRows = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf(".", "0", "Del")
        )
        buttonRows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { label ->
                    OutlinedButton(
                        onClick = {
                            when (label) {
                                "Del" -> {
                                    if (input.isNotEmpty()) {
                                        onInputChanged(input.dropLast(1))
                                    }
                                }

                                else -> {
                                    onInputChanged(input + label)
                                }
                            }
                        },
                        modifier = Modifier
                            .size(125.dp)
                            .padding(8.dp),
                        border = BorderStroke(4.dp, Color.White),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFF444444)
                        )
                    ) {
                        Text(label, fontSize = 38.sp)
                    }
                }
            }
        }
        Button(
            onClick = onApply,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(50.dp)
        ) {
            Text("Set Wager", fontSize = 24.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var count by remember { mutableIntStateOf(0) }
    var handCount by remember { mutableIntStateOf(0) }
    var wager = 0.0
    var wagerInput by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }

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
                            .clickable { showBottomSheet = true }
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
            // Bottom Sheet for the Wager input menu
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = bottomSheetState
                ) {
                    NumberPad(
                        input = wagerInput,
                        onInputChanged = { updated ->
                            wagerInput = updated
                        },
                        onApply = {
                            wager = wagerInput.toDoubleOrNull() ?: 0.0
                            showBottomSheet = false
                        }
                    )
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
