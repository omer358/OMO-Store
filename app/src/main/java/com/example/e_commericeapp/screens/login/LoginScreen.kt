package com.example.e_commericeapp.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.e_commericeapp.R
import com.example.e_commericeapp.common.composable.BasicButton
import com.example.e_commericeapp.common.composable.BasicElevatedButton
import com.example.e_commericeapp.common.composable.EmailField
import com.example.e_commericeapp.common.composable.PasswordField
import com.example.e_commericeapp.common.ext.basicButton
import com.example.e_commericeapp.common.ext.fieldModifier
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState: LoginUiState by viewModel.uiState
    LoginScreenContent(
        uiState = uiState,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_illustration),
            modifier = Modifier
                .size(300.dp),
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailField(
                value = uiState.email,
                onNewValue = onEmailChange,
                modifier = Modifier.fieldModifier()
            )
            PasswordField(
                value = uiState.password,
                onNewValue = onPasswordChange,
                modifier = Modifier.fieldModifier()
            )
            BasicButton(text = R.string.login, Modifier.basicButton()) {}
            BasicElevatedButton(text = R.string.sign_up, Modifier.basicButton()) {}
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    val uiState = LoginUiState(
        email = "email@test.com",
        password = "makiomer358"
    )
    ECommericeAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreenContent(
                uiState = uiState,
                onEmailChange = {},
                onPasswordChange = {}
            )
        }
    }
}