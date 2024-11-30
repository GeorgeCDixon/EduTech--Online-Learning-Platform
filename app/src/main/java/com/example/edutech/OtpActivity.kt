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
//import androidx.compose.ui.graphics.painter.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme

class OtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                // Retrieve data from the intent
                val email = intent.getStringExtra("USER_EMAIL") ?: ""
                val firstName = intent.getStringExtra("FIRST_NAME") ?: ""
                val lastName = intent.getStringExtra("LAST_NAME") ?: ""
                val password = intent.getStringExtra("PASSWORD") ?: ""

                // Pass the data to OtpScreen
                OtpScreen(email = email, firstName = firstName, lastName = lastName, password = password)
            }
        }
    }
}

@Composable
fun OtpScreen(email: String, firstName: String, lastName: String, password: String) {
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    val context = LocalContext.current // Get the context
    val firebaseHelper = FirebaseHelper()

    // Combine OTP inputs into a single string
    val enteredOtp = otp1 + otp2 + otp3 + otp4

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC)) // Light blue background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Heading
            Text(
                text = "Verify your account.",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )

            // Image
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your image resource
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .size(200.dp)
            )

            // OTP Instruction Text
            Text(
                text = "To continue, please check and open the email sent to you and enter the OTP you received below.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            // OTP Input Fields
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                OtpInputField(value = otp1, onValueChange = { otp1 = it })
                Spacer(modifier = Modifier.width(8.dp))
                OtpInputField(value = otp2, onValueChange = { otp2 = it })
                Spacer(modifier = Modifier.width(8.dp))
                OtpInputField(value = otp3, onValueChange = { otp3 = it })
                Spacer(modifier = Modifier.width(8.dp))
                OtpInputField(value = otp4, onValueChange = { otp4 = it })
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Resend OTP Text
            TextButton(onClick = { /* Handle resend OTP click */ }) {
                Text(
                    text = "Didn't receive the OTP? Resend OTP",
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Create Account Button
            Button(
                onClick = {
                    // Validate OTP and save user data
                    if (enteredOtp == "1234") {
                        val user = User(email, firstName, lastName, password)
                        firebaseHelper.saveUser(user)
                        val intent = Intent(context, VerifiedActivity::class.java)
                        context.startActivity(intent)
                    } else {
                        // Handle incorrect OTP (e.g., show a Toast)
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Blue, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue
                )
            ) {
                Text(
                    text = "Create Account",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun OtpInputField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .width(50.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        textStyle = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    EdutechTheme {
        OtpScreen(email = "", firstName = "", lastName = "", password = "")
    }
}
