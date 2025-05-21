package com.example.composeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}




@Composable
fun CountryCardWithConstraintLayout (countryInfo: CountryInfo){
    ConstraintLayout(modifier
            Modifier.wrapContentHeight().fillMaxWidth().padding (2.dp)
        val (flag, common Name, capital)= createRefs()

    val imageResId = countryInfo. flagId
    val imagePainter: Painter painter Resource (id = imageResId)
    Image(
        painter = imagePainter,
        contentDescription = "Country Flag",
        contentScale
                ContentScale.Crop,
        modifier = Modifier.fillMaxWidth( fraction: 8.3f)
        .height(78.dp)
        .padding (2.dp)
        .constrainAs (flag) this: ConstrainScope
    top.linkTo(parent.top)
    start.linkTo(parent.start)
    )

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

            ) {
            Button(onClick = { Log.d("MainScreen", "Button Clicked") }) {
                Text(
                    modifier = Modifier.width(150.dp),
                    text = "Hello",
                    textAlign = TextAlign.Center)
            }
            Button(onClick = { Log.d("MainScreen", "Button Clicked") }) {
                Text(
                    modifier = Modifier.width(150.dp),
                    text = "Hello",
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}