package novalogics.android.styles.data.repository.local

import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.Event

interface LocalDataRepository {

    fun getDemoBanners(): List<BannerEntity>

    fun getBannerUrls(): List<String>

    fun getDemoEventsWomen(): List<Event>

    fun getDemoEventsMen(): List<Event>

}
