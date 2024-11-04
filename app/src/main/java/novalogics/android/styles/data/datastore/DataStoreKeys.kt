package novalogics.android.styles.data.datastore

sealed class DataStoreKeys(val key: String) {
    data object SelectedFashionCategory : DataStoreKeys("fashion_category")
    data object EventName : DataStoreKeys("event_name")
}
