package com.antonio.glance.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier){

}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun SearchBarPreview() {
    GlanceTheme {
        SearchBar()
    }
}