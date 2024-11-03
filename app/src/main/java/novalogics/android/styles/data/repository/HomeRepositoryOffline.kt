package novalogics.android.styles.data.repository

import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.EventEntity

class HomeRepositoryOffline : HomeRepositoryImpl {

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


    override fun getDemoEventsWomen(): List<EventEntity> {
        return listOf(
            EventEntity(nameResId = R.string.twilight_elegance, categoryResId = R.string.evening, imageResId = R.drawable.event_women_evening),
            EventEntity(nameResId = R.string.coastal_breeze, categoryResId = R.string.beach_days, imageResId = R.drawable.event_women_beach),
            EventEntity(nameResId = R.string.gala_glamour, categoryResId = R.string.special_event, imageResId = R.drawable.event_women_gala_glamour),
            EventEntity(nameResId = R.string.mix_and_mingle, categoryResId = R.string.cocktail_party, imageResId = R.drawable.event_women_mix_mingle),
            EventEntity(nameResId = R.string.elegant_affair, categoryResId = R.string.formal_black_tie, imageResId = R.drawable.placeholder_event),

            EventEntity(nameResId = R.string.eternal_elegance, categoryResId = R.string.weddings, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.radiant_night, categoryResId = R.string.prom_or_formal_dances, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.cap_and_gown_glam, categoryResId = R.string.graduation, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.casual_couture, categoryResId = R.string.brunch_with_friends, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.bohemian_vibes, categoryResId = R.string.outdoor_festivals, imageResId = R.drawable.placeholder_event),

            EventEntity(nameResId = R.string.casual_chic, categoryResId = R.string.everyday_essence, imageResId = R.drawable.placeholder_event),
        )
    }


    override fun getDemoEventsMen(): List<EventEntity> {
        return listOf(
            EventEntity(nameResId = R.string.fearless_fierce, categoryResId = R.string.evening, imageResId = R.drawable.event_men_evening),
            EventEntity(nameResId = R.string.coastal_cool, categoryResId = R.string.beach_days, imageResId = R.drawable.event_men_beach),
            EventEntity(nameResId = R.string.gentlemans_night, categoryResId = R.string.date_nights, imageResId = R.drawable.event_men_date_night),
            EventEntity(nameResId = R.string.executive_edge, categoryResId = R.string.formal_black_tie, imageResId = R.drawable.event_men_formal),

            EventEntity(nameResId = R.string.classic_command, categoryResId = R.string.weddings, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.suave_soiree, categoryResId = R.string.prom_or_formal_dances, imageResId = R.drawable.placeholder_event),

            EventEntity(nameResId = R.string.casual_conqueror, categoryResId = R.string.brunch_with_friends, imageResId = R.drawable.placeholder_event),
            EventEntity(nameResId = R.string.festive_force, categoryResId = R.string.outdoor_festivals, imageResId = R.drawable.placeholder_event),

            EventEntity(nameResId = R.string.everyday_grit, categoryResId = R.string.everyday_essence, imageResId = R.drawable.placeholder_event),
        )
    }

}

