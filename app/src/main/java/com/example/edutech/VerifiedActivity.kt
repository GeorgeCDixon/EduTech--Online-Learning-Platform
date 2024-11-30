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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme
import kotlinx.coroutines.delay

class VerifiedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                VerifiedScreen { navigateToHome() } // Pass the navigation function
            }
        }
    }

    private fun navigateToHome() {
        // Make sure this is the correct HomeActivity class
        val intent = Intent(this, HomeScreenActivity::class.java) // Update to your actual HomeActivity class
        startActivity(intent)
        finish() // Optionally finish the current activity
    }
}

@Composable
fun VerifiedScreen(onNavigate: () -> Unit) {
    // Launch the effect to navigate after 3 seconds
    LaunchedEffect(Unit) {
        delay(3000) // Wait for 3 seconds
        onNavigate() // Call the navigation function
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Centered Image
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your image resource
                contentDescription = "Success",
                modifier = Modifier
                    .size(240.dp)
                    .padding(bottom = 16.dp)
            )

            // Account Verified Text
            Text(
                text = "Account successfully Verified.",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF004D00)
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // Welcome Text
            Text(
                text = "Welcome To Brainy Buddies",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifiedScreenPreview() {
    EdutechTheme {
        VerifiedScreen { /* No action needed for preview */ }
    }
}
