package novalogics.android.styles.data.repository.local

import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.Event
import novalogics.android.styles.data.model.home.EventEntity

interface LocalDataRepository {

    fun getDemoBanners(): List<BannerEntity>

    fun getBannerUrls(): List<String>

    fun getWomenEvents(): List<EventEntity>

    fun getDemoEventsMen(): List<Event>

}
