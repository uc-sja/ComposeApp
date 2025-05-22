package com.example.composeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

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
        setContent {
        MainScreen(indiaInfo)        }
    }
}


@Composable
fun CountryCardWithConstraintLayout(countryInfo: CountryInfo) {
    ConstraintLayout(modifier = Modifier
        .wrapContentHeight()
        .wrapContentWidth()
        .padding(2.dp)) {

        val (flag, commonName, capital) = createRefs()

        val imageResId = countryInfo.flagId
        val imagePainter: Painter = painterResource(id = imageResId)
        Image(
            painter = imagePainter,
            contentDescription = "Country Flag",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(70.dp)
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
fun MainScreen(indiaInfo1: CountryInfo) {
          Surface (modifier = Modifier.fillMaxSize().border(10.dp, _root_ide_package_.androidx.compose.ui.graphics.Color.LightGray).wrapContentHeight(align = Alignment.Top),

              color = MaterialTheme.colorScheme.surface
        ){
              CountryCardWithConstraintLayout(indiaInfo1)

    }
}

@Preview(showBackground = true, backgroundColor = 0x800000)
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
    MainScreen(indiaInfo)
}


