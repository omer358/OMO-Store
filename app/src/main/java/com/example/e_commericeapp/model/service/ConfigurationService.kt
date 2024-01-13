package com.example.e_commericeapp.model.service
interface ConfigurationService {
  suspend fun fetchConfiguration(): Boolean
  val isShowTaskEditButtonConfig: Boolean
}
