package novalogics.android.styles.data.datastore

interface DataStoreRepository {

    suspend fun putString(key: String, value: String)

    suspend fun putInt(key: String, value: Int)

    suspend fun getString(key: String, defaultValue: String): String

    suspend fun getInt(key: String, defaultValue: Int): Int
}
