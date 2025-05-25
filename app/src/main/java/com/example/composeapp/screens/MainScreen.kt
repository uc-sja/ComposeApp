package com.example.composeapp.screens

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.composeapp.components.CountryCard
import com.example.composeapp.data.CountryInfo
import com.example.composeapp.getCountryListFromJson


private const val TAG = "MainScreen"


@Composable
fun MainScreen(innerPadding: PaddingValues) {

    val context = LocalContext.current
    val countries = getCountryListFromJson(context)


    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)){

    LazyColumn() {
        items(countries) {

            Log.d(TAG, "MainScreen: countryname "+it.toString())

                CountryCard(it)

            }

        }
    }

    }

