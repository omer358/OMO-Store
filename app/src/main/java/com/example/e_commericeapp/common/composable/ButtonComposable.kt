package com.example.e_commericeapp.common.composable

import androidx.annotation.StringRes
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp


@Composable
fun BasicElevatedButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
    ElevatedButton(onClick = action, modifier = modifier) { Text(text = stringResource(text)) }
}

@Composable
fun BasicButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
    Button(
        onClick = action,
        modifier = modifier,
    ) {
        Text(text = stringResource(text), fontSize = 16.sp)
    }
}
