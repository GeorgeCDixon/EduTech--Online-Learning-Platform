package com.example.edutech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                // Pass context to HomeScreen composable
                HomeScreen(context = this)
            }
        }
    }
}

@Composable
fun HomeScreen(context: ComponentActivity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween, // Distribute space between items
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Logo at the top center
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(top = 16.dp) // Reduced padding
                    .size(150.dp) // Adjusted size for fitting
            )

            // 2. Middle Image
            Image(
                painter = painterResource(id = R.drawable.startpage),
                contentDescription = "Middle Image",
                modifier = Modifier
                    .padding(vertical = 8.dp) // Reduced vertical padding
                    .size(300.dp) // Adjusted size for fitting
            )

            // 3. Button at the middle
            Button(
                onClick = {
                    // Start EmailActivity on button click
                    val intent = Intent(context, EmailActivity::class.java)
                    context.startActivity(intent)
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 16.dp) // Keep button padding
            ) {
                Text(text = "Continue With Email")
            }

            // Spacer to fill available space below the button
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EdutechTheme {
        // Provide a dummy context for preview
        HomeScreen(context = remember { ComponentActivity() })
    }
}
