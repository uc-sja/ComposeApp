package com.example.composeapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapp.data.Country

private const val TAG = "CountryCard"

@Composable
fun CountryCard(country: Country){
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .border(
                        2.dp,
                        _root_ide_package_.androidx.compose.ui.graphics.Color.Black,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .wrapContentHeight(align = Alignment.Top),
                shadowElevation = 2.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                CountryCardWithConstraintLayout(country)

            }



    }