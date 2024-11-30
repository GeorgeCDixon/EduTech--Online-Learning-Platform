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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme
import androidx.compose.ui.platform.LocalContext

class AccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                AccountScreen()
            }
        }
    }
}

@Composable
fun AccountScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    val context = LocalContext.current // Get the context


    // Retrieve the email from the intent
    val email = (context as? AccountActivity)?.intent?.getStringExtra("USER_EMAIL") ?: ""

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo at the top center
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(top = 0.dp)
                    .size(250.dp)
            )

            // Form container
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                // Heading
                Text(
                    text = "Create new account",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    textAlign = TextAlign.Center
                )

                // Subtitle Text
                Text(
                    text = "What’s your name to be called?",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // First Name
                Text(
                    text = "First name",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = { Text("Enter your first name") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                // Last Name
                Text(
                    text = "Last name",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = { Text("Enter your last name") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Next Button
                Button(
                    onClick = {
                        val intent = Intent(context, PasswordCreationActivity::class.java).apply {
                            putExtra("USER_EMAIL", email) // Pass the email
                            putExtra("FIRST_NAME", firstName) // Pass the first name
                            putExtra("LAST_NAME", lastName) // Pass the last name
                        }
                        context.startActivity(intent)
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Blue, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Next",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sign In Link
                TextButton(onClick = { /* Handle sign in click */ }) {
                    Text(
                        text = "Already have an account? Sign In",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    EdutechTheme {
        AccountScreen()
    }
}
