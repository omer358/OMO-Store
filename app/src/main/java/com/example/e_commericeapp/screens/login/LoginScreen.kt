package com.example.e_commericeapp.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e_commericeapp.R
import com.example.e_commericeapp.common.composable.BasicToolbar
import com.example.e_commericeapp.common.composable.EmailField
import com.example.e_commericeapp.common.composable.PasswordField
import com.example.e_commericeapp.common.ext.fieldModifier
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
            Button(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.login))
            }
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