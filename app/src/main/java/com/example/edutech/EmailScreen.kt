package com.example.edutech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edutech.ui.theme.EdutechTheme
import androidx.compose.ui.platform.LocalContext


class EmailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                EmailScreen()
            }
        }
    }
}

@Composable
fun EmailScreen() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current // Get the context

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
    ) {
        // Column for the centered content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Middle Image
            Image(
                painter = painterResource(id = R.drawable.emailpage),
                contentDescription = "Middle Image",
                modifier = Modifier
                    .padding(25.dp)
                    .size(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Text1: What is your Email?
            Text(
                text = "What is your Email?",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp) // Reduced space between texts
            )

            // Text2: Smaller text
            Text(
                text = "We need to look up your account or create a new one.",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp) // Adjusted padding
            )

            // TextInput Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White), // White background for text input
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Next Button
            Button(
                onClick = { // Start EmailActivity on button click
                    val intent = Intent(context, AccountActivity::class.java).apply {
                        putExtra("USER_EMAIL", email.text) // Pass the email to AccountActivity
                    }
                    context.startActivity(intent) },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                )
            ) {
                Text(text = "Next", fontWeight = FontWeight.Bold) // Bold text
            }
        }

        // Column for the top content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp), // Add padding to position the logo
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Logo at the top center
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailScreenPreview() {
    EdutechTheme {
        EmailScreen()
    }
}
