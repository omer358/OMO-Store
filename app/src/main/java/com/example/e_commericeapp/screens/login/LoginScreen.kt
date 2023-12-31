package com.example.e_commericeapp.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.e_commericeapp.R
import com.example.e_commericeapp.common.composable.BasicButton
import com.example.e_commericeapp.common.composable.BasicElevatedButton
import com.example.e_commericeapp.common.composable.BasicToolbar
import com.example.e_commericeapp.common.composable.EmailField
import com.example.e_commericeapp.common.composable.PasswordField
import com.example.e_commericeapp.common.ext.basicButton
import com.example.e_commericeapp.common.ext.fieldModifier
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme

@Composable
fun LoginScreen(
) {
    LoginScreenContent()
}

@Composable
fun LoginScreenContent() {
    Scaffold (
        topBar = { BasicToolbar(title = R.string.login)}
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailField("", {}, Modifier.fieldModifier())
            PasswordField("", {}, Modifier.fieldModifier())
            BasicButton(text = R.string.login, Modifier.basicButton()) {}
            BasicElevatedButton(text = R.string.sign_up, Modifier.basicButton()) {}
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    ECommericeAppTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreenContent()
        }
    }
}