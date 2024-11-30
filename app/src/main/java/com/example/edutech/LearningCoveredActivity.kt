package com.example.edutech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.edutech.ui.theme.EdutechTheme
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.times

class LearningCoveredActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechTheme {
                LearningCoveredScreen()
            }
        }
    }
}

@Composable
fun LearningCoveredScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B4D8)) // Light blue background color
            .padding(16.dp)
    ) {
        // Image covering 1/3 of the screen height
        Image(
            painter = painterResource(id = R.drawable.kathandhara), // Replace with your image resource
            contentDescription = "Learning Image",
            modifier = Modifier
                .fillMaxWidth()
                .height((1f / 3) * LocalConfiguration.current.screenHeightDp.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Centered Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.kathandhara3), // Replace with your image resource
                contentDescription = "Centered Image",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "2/15 Completed" Text
        Text(
            text = "2/15 Completed",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            textAlign = Alignment.CenterHorizontally
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Scrollable table with sample data using LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Make the table scrollable and take the available space
        ) {
            item {
                // Table header row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Lesson 1", fontWeight = FontWeight.Bold)
                    Text("Lesson Name", fontWeight = FontWeight.Bold)
                    Text("Completed", fontWeight = FontWeight.Bold)
                }
                HorizontalDivider(thickness = 1.dp, color = Color.Black)
            }

            // Add sample lesson rows
            items(10) { index ->
                LessonRow(
                    lessonNumber = "Lesson ${index + 1}",
                    lessonName = "Lesson Name $index",
                    completed = if (index % 2 == 0) "Yes" else "No"
                )
            }
        }

        // Spacer for button positioning
        Spacer(modifier = Modifier.height(16.dp))

        // "Resume Learning" Button
        Button(
            onClick = { /* Handle Resume Learning click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Resume Learning", color = Color.White)
        }
    }
}

fun Text(text: String, style: TextStyle, modifier: Modifier, color: Color, textAlign: Alignment.Horizontal) {

}

@Composable
fun LessonRow(lessonNumber: String, lessonName: String, completed: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(lessonNumber)
        Text(lessonName)
        Text(completed)
    }
}

@Preview(showBackground = true)
@Composable
fun LearningCoveredScreenPreview() {
    EdutechTheme {
        LearningCoveredScreen()
    }
}
