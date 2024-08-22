package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TopicsApp()
                }
            }
        }
    }
}
@Composable
fun TopicsApp(){

}

@Composable
fun GridItem(topic: Topic, modifier: Modifier = Modifier) {

    Card (
        modifier = modifier
            .height(68.dp)

    ) {
        Row (
            modifier = modifier
        ) {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ){
                Text(
                    text = stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(bottom = 8.dp)
                )

                IconIdRow(
                    topic,
                    modifier)
            }


        }
    }
}

@Composable
fun IconIdRow(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Row {
        Icon(Icons.Rounded.Info,
            contentDescription = stringResource(topic.stringResourceId),
            modifier.padding(end = 8.dp)
        )
        Text(
            text = topic.courseId.toString(),
            style = MaterialTheme.typography.labelMedium,
            modifier = modifier.padding(top = 4.dp, bottom = 4.dp)
        )

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesAppTheme {
        GridItem(Topic(R.string.architecture, courseId = 68, R.drawable.architecture))
    }
}