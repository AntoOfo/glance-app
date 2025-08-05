package com.antonio.glance.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier){
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 2.dp,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)),
        modifier = modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = {},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "Looking for news?",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 12.sp)
            },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun SearchBarPreview() {
    GlanceTheme {
        SearchBar()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.large,
        shadowElevation = 2.dp,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)),
        modifier = modifier.fillMaxWidth()
    ) {

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun CategoryRowPreview() {
    GlanceTheme {
        CategoryRow()
    }
}