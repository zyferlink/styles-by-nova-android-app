package novalogics.android.styles.data.repository.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.EventEntity
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : LocalDataRepository {

    override fun getDemoBanners(): List<BannerEntity> {
        return listOf(
            BannerEntity(imageResId = R.drawable.banner_men),
            BannerEntity(imageResId = R.drawable.banner_women),
            BannerEntity(imageResId = R.drawable.placeholder_banner_error),
        )
    }

    override fun getBannerUrls(): List<String> {
        return listOf(
            "https://i.imghippo.com/files/PaeJm1729158477.png",
            "https://i.imghippo.com/files/F0xn31729159097.jpg",
            "https://i.imghippo.com/files/PaeJm1729158477.png",
        )
    }

    override fun getWomenEvents(): List<EventEntity> {
        return StaticRepository.getWomenEvents(context = context)
    }

    override fun getMenEvents(): List<EventEntity> {
        return StaticRepository.getMenEvents(context = context)
    }

}

