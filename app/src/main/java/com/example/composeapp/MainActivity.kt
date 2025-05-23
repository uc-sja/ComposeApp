package com.example.composeapp

import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composeapp.components.CountryCardWithConstraintLayout
import com.example.composeapp.data.CountryInfo

private const val TAG = "MainActivity"


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
fun MainScreen(indiaInfo1: CountryInfo) {

            val context = LocalContext.current
    val countries = getCountryListFromJson(context)

              LazyColumn() {
                  items(countries) {
                      Log.d(TAG, "MainScreen: "+it.toString())


                      Surface(modifier = Modifier.fillMaxSize()
                          .padding(horizontal = 10.dp, vertical = 5.dp)
                          .border(2.dp, _root_ide_package_.androidx.compose.ui.graphics.Color.Black, shape = RoundedCornerShape(10.dp))
                          .wrapContentHeight(align = Alignment.Top),
                          shadowElevation = 2.dp,
                          color = MaterialTheme.colorScheme.surface
                      ){
                          CountryCardWithConstraintLayout(it)

                      }

                  }
              }

}

@Preview(showBackground = true, backgroundColor = 0xffffff)
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


