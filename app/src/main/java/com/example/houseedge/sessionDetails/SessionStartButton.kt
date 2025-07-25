package com.example.houseedge.sessionDetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SessionStartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 120.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = onClick,
            enabled = true,
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, color = Color.White),
            modifier = modifier
                .size(400.dp, 150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6C6060),
                contentColor = Color.Black,
            ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
            ) {
                Text(
                    text = "START ",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight(900),
                    fontStyle = FontStyle.Italic,

                )
                Text(
                    text = "COUNT",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight(900),
                    fontStyle = FontStyle.Italic,

                )
            }
        }
    }
}
