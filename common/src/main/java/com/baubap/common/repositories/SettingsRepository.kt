package com.baubap.common.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

data class Settings(
    val accessToken: String?,
    val user: User?,
)

private val userIdKey = stringPreferencesKey("user-id")
private val userNameKey = stringPreferencesKey("user-name")
private val userEmailKey = stringPreferencesKey("user-email")
private val userUsernameKey = stringPreferencesKey("user-username")
private val accessTokenKey = stringPreferencesKey("access-token")

class SettingsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) {

    suspend fun settings(): Settings? = dataStore.data.first().toPreferences().toSettings()

    suspend fun save(settings: Settings): Boolean {
        dataStore.edit { preferences -> preferences.update(settings) }
        return true
    }

    private fun Preferences.toSettings(): Settings? {
        val userId = this[userIdKey] ?: return null
        val userName = this[userNameKey]
        val userUsername = this[userUsernameKey]
        val userEmail = this[userEmailKey]
        val accessToken = this[accessTokenKey]

        return Settings(
            user = User(
                id = userId,
                name = userName!!,
                username = userUsername!!,
                email = userEmail!!,
            ),
            accessToken = accessToken,
        )
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }
}

private fun MutablePreferences.update(settings: Settings) {
    settings.user?.let {
        this[userIdKey] = it.id
        this[userNameKey] = it.name
        this[userUsernameKey] = it.username
        this[userEmailKey] = it.email
    }
    settings.accessToken?.let { this[accessTokenKey] = it }
}