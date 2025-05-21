package com.example.composeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.codetutor.countryinfoapp.data.CountryInfo
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {

    private val indiaInfo = CountryInfo(
        R.drawable.`in`,
        "India",
        "New Delhi",
        "Republic of India",
        "Asia", "South Asia",
        "₹",
        "Indian Rupee",
        "+91",
        ".in"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryCardWithConstraintLayout(indiaInfo)
        }
    }
}


@Composable
fun CountryCardWithConstraintLayout(countryInfo: CountryInfo) {
    ConstraintLayout(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(2.dp)) {

        val (flag, commonName, capital) = createRefs()

        val imageResId = countryInfo.flagId
        val imagePainter: Painter = painterResource(id = imageResId)
        Image(
            painter = imagePainter,
            contentDescription = "Country Flag",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(70.dp)
                .padding(2.dp)
                .constrainAs(flag) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)

                }
        )
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(onClick = { Log.d("MainScreen", "Button Clicked") }) {
                Text(
                    modifier = Modifier.width(150.dp),
                    text = "Hello",
                    textAlign = TextAlign.Center
                )
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
    val indiaInfo = CountryInfo(
        R.drawable.`in`,
        "India",
        "New Delhi",
        "Republic of India",
        "Asia", "South Asia",
        "₹",
        "Indian Rupee",
        "+91",
        ".in"
    )
    CountryCardWithConstraintLayout(indiaInfo)
}


