package com.rama.expensetrackerapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rama.expensetrackerapp.ui.theme.ExpenseTrackerAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAppBar(
    title: String
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        modifier = Modifier
            .shadow(8.dp,)
            .background(color = Color.Cyan),
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowPreview(){
    ExpenseTrackerAppTheme {
        ScreenAppBar("Expense Tracker")
    }

}