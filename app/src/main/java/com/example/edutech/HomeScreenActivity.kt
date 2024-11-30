package com.example.edutech

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edutech.ui.theme.EdutechTheme
import androidx.compose.ui.platform.LocalContext

class HomeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                HomeScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current // Get the context

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Padding around the entire column
            verticalArrangement = Arrangement.spacedBy(8.dp) // Reduce space between elements
        ) {
            // Logo Image
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 5.dp) // Reduced margin between logo and search bar
                    .size(180.dp)
            )

            // Search Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search_icon), // Replace with your search icon
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 7.dp)
                )
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Search",
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }

            // Banner Image
            Image(
                painter = painterResource(id = R.drawable.announcement1), // Replace with your banner image
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Announcement Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Announcement",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    ),
                    textAlign = TextAlign.End,
                            modifier = Modifier.clickable {
                                val intent = Intent(context, AnnouncementActivity::class.java)
                                context.startActivity(intent)
                    } // Navigate to AnnouncementActivity when clicked
                )
            }

            // Courses Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier.clickable {
                        val intent = Intent(context, CoursesActivity::class.java)
                        context.startActivity(intent)
                    } // Navigate to AnnouncementActivity when clicked
                )
            }

            // Two Images in a Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vachanapiyasa1), // Replace with your image resource
                    contentDescription = "Course Image 1",
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 3.dp)
                        .height(150.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.kurupiyasa1), // Replace with your image resource
                    contentDescription = "Course Image 2",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 3.dp)
                        .height(150.dp)
                )
            }

            // Another Two Images in a Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.akurup), // Replace with your image resource
                    contentDescription = "Course Image 3",
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp)
                        .height(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.vachanapiyasa3), // Replace with your image resource
                    contentDescription = "Course Image 4",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp)
                        .height(80.dp)
                )
            }

            // Ensure enough space for the bottom icon bar
            Spacer(modifier = Modifier.weight(1f)) // Take up remaining space to push the icon bar down
        }

        // Custom Icon Bar at the bottom
        CustomIconBar(
            modifier = Modifier.align(Alignment.BottomCenter) // Align the CustomIconBar to the bottom center
        )
    }
}

@Composable
fun CustomIconBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  val intent = Intent(context, HomeScreenActivity::class.java)
            context.startActivity(intent) }) {
            Image(
                painter = painterResource(id = R.drawable.ic_home), // Ensure this drawable exists
                contentDescription = "Home Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = { val intent = Intent(context, AnnouncementActivity::class.java)
            context.startActivity(intent) }) {
            Image(
                painter = painterResource(id = R.drawable.ic_news), // Ensure this drawable exists
                contentDescription = "News Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = {  val intent = Intent(context, LearningCoveredActivity::class.java)
            context.startActivity(intent) }) {
            Image(
                painter = painterResource(id = R.drawable.ic_learning), // Ensure this drawable exists
                contentDescription = "Learning Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = { /* Handle Profile Click */ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile), // Ensure this drawable exists
                contentDescription = "Profile Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreensPreview() {
    EdutechTheme {
        HomeScreen()
    }
}
