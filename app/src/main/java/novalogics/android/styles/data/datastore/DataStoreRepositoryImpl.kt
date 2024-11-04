package novalogics.android.styles.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import novalogics.android.styles.data.type.FashionCategory
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    // Generic method to save a string value using a key
    suspend fun saveString(key: DataStoreStringKey, value: String) {
        dataStore.edit { preferences ->
            preferences[key.key as Preferences.Key<String>]  = value
        }
    }

    // Generic method to retrieve a string value using a key
    fun getStringFlow(key: DataStoreStringKey): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[key.key] as String
        }
    }


    val getFashionCategory: Flow<String> = dataStore.data
        .map { pref ->
            pref[DataStoreStringKey.FashionCategory.key] ?: FashionCategory.DEFAULT.name
        }

    suspend fun saveFashionCategory(value: String) {
        dataStore.edit { preferences ->
            preferences[DataStoreStringKey.FashionCategory.key] = value
        }
    }

}
