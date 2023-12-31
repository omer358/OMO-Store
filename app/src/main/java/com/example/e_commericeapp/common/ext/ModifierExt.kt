package com.example.e_commericeapp.common.ext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

fun Modifier.fieldModifier(): Modifier {
    return this
        .fillMaxWidth()
        .clip(
            CircleShape.copy(CornerSize(8.dp))
        )
        .padding(16.dp, 4.dp)
}

fun Modifier.basicButton(): Modifier {
    return this.padding(16.dp, 8.dp)
}