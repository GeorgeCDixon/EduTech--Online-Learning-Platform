package com.example.edutech

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme


class AnnouncementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                AnnouncementScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnnouncementScreen() {

    Scaffold(
        bottomBar = {
            CustomBottomNavigationBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
                .background(Color(0xFF00B4D8)) // Light blue background
        ) {
            // Header
            Text(
                text = "Announcement",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 50.dp, start = 20.dp)
            )

            // First Banner
            Image(
                painter = painterResource(id = R.drawable.announcement1), // Replace with your banner image resource
                contentDescription = "Banner 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
            )

            // First Row of Icon and Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.eye_icon), // Replace with your icon
                        contentDescription = "Views Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Views", modifier = Modifier.padding(start = 8.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.watch_icon), // Replace with your icon
                        contentDescription = "Time Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "3 Mins", modifier = Modifier.padding(start = 8.dp))
                }
                Text(
                    text = "Read More",
                    color = Color.Blue,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Second Banner
            Image(
                painter = painterResource(id = R.drawable.announcement2), // Replace with your banner image resource
                contentDescription = "Banner 2",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Second Row of Icon and Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.eye_icon), // Replace with your icon
                        contentDescription = "Views Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Views", modifier = Modifier.padding(start = 8.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.watch_icon), // Replace with your icon
                        contentDescription = "Time Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "3 Mins", modifier = Modifier.padding(start = 8.dp))
                }
                Text(
                    text = "Read More",
                    color = Color.Blue,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Pagination buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /* Navigate to page 1 */ },
                    modifier = Modifier.padding(end = 8.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "1", color = Color.White)
                }
                Button(
                    onClick = { /* Navigate to page 2 */ },
                    modifier = Modifier.padding(end = 8.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text(text = "2", color = Color.White)
                }
                Button(
                    onClick = { /* Navigate to page 3 */ },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text(text = "3", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CustomBottomNavigationBar() {
    val context = LocalContext.current
    // Create a row that holds the icons and labels
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp), // Add vertical padding for spacing
        horizontalArrangement = Arrangement.SpaceAround, // Space items evenly
        verticalAlignment = Alignment.CenterVertically // Align them in the center vertically
    ) {
        // Home Icon
        IconWithLabel(
            iconId = R.drawable.ic_home, // Use your drawable resource
            label = "Home",
            onClick = { val intent = Intent(context, HomeScreenActivity::class.java)
                context.startActivity(intent) }
        )

        // News Icon
        IconWithLabel(
            iconId = R.drawable.ic_news, // Use your drawable resource
            label = "News",
            onClick = { val intent = Intent(context, AnnouncementActivity::class.java)
                context.startActivity(intent) }
        )

        // Learning Icon
        IconWithLabel(
            iconId = R.drawable.ic_learning, // Use your drawable resource
            label = "Learning",
            onClick = {
                val intent = Intent(context, LearningCoveredActivity::class.java)
                context.startActivity(intent)
            }
        )

        // Profile Icon
        IconWithLabel(
            iconId = R.drawable.ic_profile, // Use your drawable resource
            label = "Profile",
            onClick = { /* Handle Profile Click */ }
        )
    }
}

@Composable
fun IconWithLabel(iconId: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        // Icon from the drawable resource
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(24.dp), // Set icon size
            tint = Color.Black // Set icon color to black
        )
        // Label under the icon
        Text(
            text = label,
            color = Color.Black,
            style = MaterialTheme.typography.bodySmall, // Use a small text style
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp) // Space between icon and text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnnouncementScreenPreview() {
    EdutechTheme {
        AnnouncementScreen()
    }
}
