package com.example.e_commericeapp.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.e_commericeapp.R
import com.example.e_commericeapp.common.composable.BasicButton
import com.example.e_commericeapp.common.composable.BasicElevatedButton
import com.example.e_commericeapp.common.composable.BasicToolbar
import com.example.e_commericeapp.common.composable.EmailField
import com.example.e_commericeapp.common.composable.PasswordField
import com.example.e_commericeapp.common.ext.basicButton
import com.example.e_commericeapp.common.ext.fieldModifier
import com.example.e_commericeapp.ui.theme.ECommericeAppTheme

private const val TAG = "LoginScreen"
@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: LoginViewModel = LoginViewModel()
) {
    val uiState: LoginUiState by viewModel.uiState.collectAsState()
    LoginScreenContent(
        uiState = uiState,
        onEmailChange = { viewModel.onEmailChange(it) },
        onPasswordChange = {viewModel.onPasswordChange(it)},
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Log.i(TAG, "LoginScreenContent: ${uiState.email}")
    Log.i(TAG, "LoginScreenContent: ${uiState.email}")
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isVisible: Boolean by remember { mutableStateOf(false) }

    val icon: Painter =
        if (isVisible) painterResource(R.drawable.ic_visibility_on)
        else painterResource(R.drawable.ic_visibility_off)
    val visualTransformation =
        if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
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
            OutlinedTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                placeholder = { Text(stringResource(R.string.email)) },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
                        modifier = Modifier.fieldModifier()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(8.dp),
                placeholder = { Text(text = stringResource(R.string.password)) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock") },
                trailingIcon = {
                    IconButton(onClick = { isVisible = !isVisible }) {
                        Icon(painter = icon, contentDescription = "Visibility")
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = visualTransformation,
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