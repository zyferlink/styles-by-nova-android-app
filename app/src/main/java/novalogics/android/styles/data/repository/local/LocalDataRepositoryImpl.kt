package novalogics.android.styles.data.repository.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.EventEntity
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : LocalDataRepository {

    override fun getDemoBanners(): List<BannerEntity> = StaticRepository.getBanners()

    override fun getBannerUrls(): List<String> {
        return listOf(
            "https://i.imghippo.com/files/PaeJm1729158477.png",
            "https://i.imghippo.com/files/F0xn31729159097.jpg",
            "https://i.imghippo.com/files/PaeJm1729158477.png",
        )
    }

    override fun getWomenEvents(): List<EventEntity> =
        StaticRepository.getWomenEvents(context = context)

    override fun getMenEvents(): List<EventEntity> =
        StaticRepository.getMenEvents(context = context)

}

