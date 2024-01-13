package com.example.e_commericeapp.model.service.impl

import com.example.e_commericeapp.R
import com.example.e_commericeapp.model.service.ConfigurationService
import com.google.firebase.BuildConfig
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import javax.inject.Inject

class ConfigurationServiceImpl @Inject constructor() : ConfigurationService {
  private val remoteConfig
    get() = Firebase.remoteConfig

  init {
    if (BuildConfig.DEBUG) {
      val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 0 }
      remoteConfig.setConfigSettingsAsync(configSettings)
    }

    remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
  }

  override suspend fun fetchConfiguration(): Boolean = true

  override val isShowTaskEditButtonConfig: Boolean
    get() = true

  companion object {
    private const val SHOW_TASK_EDIT_BUTTON_KEY = "show_task_edit_button"
    private const val FETCH_CONFIG_TRACE = "fetchConfig"
  }
}
