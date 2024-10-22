package novalogics.android.styles.data.repository

import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.EventEntity

interface HomeRepositoryImpl {
    fun getDemoBanners(): List<BannerEntity>

    fun getBannerUrls(): List<String>

    fun getDemoEventsWomen(): List<EventEntity>

    fun getDemoEventsMen(): List<EventEntity>

}
