package com.example.e_commericeapp.screens.splash_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme

@Composable
fun SplashScreen(){
    SplashScreenContent()
}

@Composable
fun SplashScreenContent(){

}


@Preview
@Composable
fun SplashScreenPreview(){
    ECommericeAppTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreenContent()
        }
    }
}