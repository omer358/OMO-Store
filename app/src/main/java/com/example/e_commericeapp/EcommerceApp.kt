@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.e_commericeapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme

@Composable
fun EcommerceApp() {
    ECommericeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}

@Composable
fun BasicToolbar(@StringRes title: Int) {
    TopAppBar(title = { Text(stringResource(title)) })
}

@Composable
fun ActionToolbar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(stringResource(title)) },
        modifier = modifier
    )
}


@Composable
fun Greeting() {
    ActionToolbar(title = R.string.home, modifier = Modifier.wrapContentSize(Alignment.TopEnd))
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ecommerce App")
    }
}
