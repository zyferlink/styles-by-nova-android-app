package novalogics.android.styles.data.datastore

sealed class DataStoreKeys(val key: String) {
    data object FashionCategory : DataStoreKeys("fashion_category")
    data object EventName : DataStoreKeys("event_name")
}
