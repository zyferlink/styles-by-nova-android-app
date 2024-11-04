package novalogics.android.styles.data.datastore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey

sealed class DataStoreStringKey(val key: Preferences.Key<String>) {
    data object FashionCategory : DataStoreStringKey(stringPreferencesKey("fashion_category"))
}
