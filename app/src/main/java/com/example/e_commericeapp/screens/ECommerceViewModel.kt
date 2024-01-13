package com.example.e_commericeapp.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commericeapp.common.snackbar.SnackbarManager
import com.example.e_commericeapp.common.snackbar.SnackbarMessage.Companion.toSnackbarMessage
import com.example.makeitso.model.service.LogService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class ECommerceViewModel(private val logService: LogService) : ViewModel(){
    fun launchCatching(snackbar: Boolean = true, block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                if (snackbar) {
                    Log.i(TAG, "launchCatching: ${throwable.message}")
                    SnackbarManager.showMessage(throwable.toSnackbarMessage())
                }
                logService.logNonFatalCrash(throwable)
            },
            block = block
        )

    companion object{
        private const val TAG = "MakeItSoViewModel"
    }
}
