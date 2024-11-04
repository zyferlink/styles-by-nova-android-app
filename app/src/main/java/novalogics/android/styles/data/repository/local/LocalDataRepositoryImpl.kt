package novalogics.android.styles.data.repository.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.Event
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


    override fun getDemoEventsMen(): List<Event> {
        return listOf(
            Event(nameResId = R.string.fearless_fierce, categoryResId = R.string.evening, imageResId = R.drawable.event_men_evening),
            Event(nameResId = R.string.coastal_cool, categoryResId = R.string.beach_days, imageResId = R.drawable.event_men_beach),
            Event(nameResId = R.string.gentlemans_night, categoryResId = R.string.date_nights, imageResId = R.drawable.event_men_date_night),
            Event(nameResId = R.string.executive_edge, categoryResId = R.string.formal_black_tie, imageResId = R.drawable.event_men_formal),

            Event(nameResId = R.string.classic_command, categoryResId = R.string.weddings, imageResId = R.drawable.placeholder_event),
            Event(nameResId = R.string.suave_soiree, categoryResId = R.string.prom_or_formal_dances, imageResId = R.drawable.placeholder_event),

            Event(nameResId = R.string.casual_conqueror, categoryResId = R.string.brunch_with_friends, imageResId = R.drawable.placeholder_event),
            Event(nameResId = R.string.festive_force, categoryResId = R.string.outdoor_festivals, imageResId = R.drawable.placeholder_event),

            Event(nameResId = R.string.everyday_grit, categoryResId = R.string.everyday_essence, imageResId = R.drawable.placeholder_event),
        )
    }

}

