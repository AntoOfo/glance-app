package com.antonio.glance.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Spacer(Modifier.height(16.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))

        NewsVerticalPager()
    }
}





