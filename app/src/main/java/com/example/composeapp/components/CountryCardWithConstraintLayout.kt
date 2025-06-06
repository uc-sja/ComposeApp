package com.example.composeapp.components


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.composeapp.data.Country

@Composable
fun CountryCardWithConstraintLayout(country: Country){
    ConstraintLayout(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()

    ) {
        val (flag, commonName, capital, officialName, region, subregion, currencySymbol, currencyName, mobileCode, tld) = createRefs()

        country?.let {
            AsyncImage(model = it?.flags?.png,
                contentScale = ContentScale.Crop,
                contentDescription = it?.flag,
                modifier =Modifier.fillMaxWidth(0.40f)
                    .clip(RoundedCornerShape(10.dp))
                    .height(70.dp)
                    .padding(2.dp)
                    .constrainAs(flag) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
        }


        country.name?.common?.let {
            Text(
                text = it,
                modifier = Modifier
                    .padding(2.dp)
                    .constrainAs(commonName) {
                        top.linkTo(flag.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(flag.end)
                    },
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontSize = 17.sp
            )
        }

        country.capital?.get(0)?.let {
            Text(text = it,
                fontSize = 15.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(2.dp)
                    .constrainAs(capital) {
                        start.linkTo(parent.start)
                        top.linkTo(commonName.bottom)
                        end.linkTo(flag.end)
                    })
        }

        country.name?.official?.let {
            Text(text = it,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(officialName) {
                        top.linkTo(parent.top)
                        start.linkTo(flag.end)
                        end.linkTo(parent.end)
                    }
                    .padding(2.dp)
                    .fillMaxWidth(0.60f))
        }

        country?.region?.let {
            Text(text = it,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(region) {
                        start.linkTo(flag.end)
                        end.linkTo(parent.end)
                        top.linkTo(officialName.bottom)
                    }
                    .padding(2.dp)
                    .fillMaxWidth(0.6f))
        }

        country.subregion?.let {
            Text(text = it,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(subregion) {
                        start.linkTo(officialName.start)
                        top.linkTo(region.bottom)
                        end.linkTo(officialName.end)
                    }
                    .padding(2.dp)
                    .fillMaxWidth(0.6f))
        }

        country?.currencies?.entries?.first()?.let{
            CircularText(text = it.value.symbol.toString(),
                modifier = Modifier
                    .constrainAs(currencySymbol) {
                        start.linkTo(flag.end, margin = 30.dp)
                        bottom.linkTo(flag.bottom, margin = 8.dp)
                    })
        }

        country?.currencies?.entries?.first()?.let{
            Text(text = it.value.name.toString(),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(currencyName) {
                        top.linkTo(subregion.bottom)
                        start.linkTo(currencySymbol.end, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                        end.linkTo(mobileCode.start, margin = 5.dp)
                    }
                    .padding(10.dp)
                    .fillMaxWidth(0.4f)
            )
        }

        country.idd?.let {
            Text(
                text = it.root+""+it.suffixes?.get(0),
                modifier = Modifier
                    .constrainAs(mobileCode) {
                        top.linkTo(subregion.bottom)
                        end.linkTo(parent.end)
                    }
                    .width(50.dp)
            )
        }

        country.tld?.get(0)?.let {
            Text(
                text = it,
                modifier = Modifier
                    .constrainAs(tld) {
                        top.linkTo(mobileCode.bottom)
                        end.linkTo(parent.end)
                    }
                    .width(50.dp)
            )
        }
    }
}