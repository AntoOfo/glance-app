package com.antonio.glance.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antonio.glance.ui.theme.GlanceTheme
import com.antonio.glance.viewmodels.GlanceViewModel

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

// searchbar replacement
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit) {

    var selectedIndex by remember { mutableStateOf(0) }
    val options = listOf("General", "Business", "Tech", "Sports")

    SingleChoiceSegmentedButtonRow(
        modifier = modifier.fillMaxWidth()
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = {
                    selectedIndex = index
                    val category = if (label == "Tech") "technology" else label.lowercase()
                    onCategorySelected(category)
                          },
                selected = index == selectedIndex,
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
                    inactiveBorderColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
                    activeBorderColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                )
                    ) {
                        Text(label)
                    }
                }
        }
    }

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, backgroundColor = 0xFFEEEEEE)
@Composable
fun CategoryRowPreview() {
    GlanceTheme {
        CategoryRow(
            //viewModel = TODO(),
            modifier = TODO(),
            onCategorySelected = TODO()
        )
    }
}