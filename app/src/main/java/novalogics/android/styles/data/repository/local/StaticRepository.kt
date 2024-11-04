package novalogics.android.styles.data.repository.local

import android.content.Context
import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.BannerEntity
import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.type.FashionCategory

object StaticRepository {

    private const val BANNER_BASE_URL = "https://i.imghippo.com/files"

    fun getBanners(): List<BannerEntity> = listOf(
        BannerEntity(imageResId = R.drawable.banner_men),
        BannerEntity(imageResId = R.drawable.banner_women),
        BannerEntity(imageResId = R.drawable.placeholder_banner_error),
    )


    fun getBannerUrls(): List<String> = listOf(
        "${BANNER_BASE_URL}/PaeJm1729158477.png",
        "${BANNER_BASE_URL}/F0xn31729159097.jpg",
        "${BANNER_BASE_URL}/PaeJm1729158477.png",
    )


    // -- Women Events
    fun getWomenEvents(context: Context): List<EventEntity> = listOf(
        EventEntity(
            id = 1001,
            name = context.getString(R.string.twilight_elegance),
            eventCategory = context.getString(R.string.evening),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.event_women_evening,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1002,
            name = context.getString(R.string.coastal_breeze),
            eventCategory = context.getString(R.string.beach_days),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.event_women_beach,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1003,
            name = context.getString(R.string.gala_glamour),
            eventCategory = context.getString(R.string.special_event),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.event_women_gala_glamour,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1004,
            name = context.getString(R.string.mix_and_mingle),
            eventCategory = context.getString(R.string.cocktail_party),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.event_women_mix_mingle,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1005,
            name = context.getString(R.string.elegant_affair),
            eventCategory = context.getString(R.string.formal_black_tie),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1006,
            name = context.getString(R.string.eternal_elegance),
            eventCategory = context.getString(R.string.weddings),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1007,
            name = context.getString(R.string.radiant_night),
            eventCategory = context.getString(R.string.prom_or_formal_dances),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1008,
            name = context.getString(R.string.cap_and_gown_glam),
            eventCategory = context.getString(R.string.graduation),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1009,
            name = context.getString(R.string.casual_couture),
            eventCategory = context.getString(R.string.brunch_with_friends),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1010,
            name = context.getString(R.string.bohemian_vibes),
            eventCategory = context.getString(R.string.outdoor_festivals),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 1011,
            name = context.getString(R.string.casual_chic),
            eventCategory = context.getString(R.string.everyday_essence),
            fashionCategory = FashionCategory.WOMEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
    )

    // -- Men Events
    fun getMenEvents(context: Context): List<EventEntity> = listOf(
        EventEntity(
            id = 2001,
            name = context.getString(R.string.fearless_fierce),
            eventCategory = context.getString(R.string.evening),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.event_men_evening,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2002,
            name = context.getString(R.string.coastal_cool),
            eventCategory = context.getString(R.string.evening),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.event_men_beach,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2003,
            name = context.getString(R.string.gentlemans_night),
            eventCategory = context.getString(R.string.date_nights),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.event_men_date_night,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2004,
            name = context.getString(R.string.executive_edge),
            eventCategory = context.getString(R.string.formal_black_tie),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.event_men_formal,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2005,
            name = context.getString(R.string.classic_command),
            eventCategory = context.getString(R.string.weddings),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2006,
            name = context.getString(R.string.suave_soiree),
            eventCategory = context.getString(R.string.prom_or_formal_dances),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2007,
            name = context.getString(R.string.casual_conqueror),
            eventCategory = context.getString(R.string.brunch_with_friends),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2008,
            name = context.getString(R.string.festive_force),
            eventCategory = context.getString(R.string.outdoor_festivals),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
        EventEntity(
            id = 2009,
            name = context.getString(R.string.everyday_grit),
            eventCategory = context.getString(R.string.everyday_essence),
            fashionCategory = FashionCategory.MEN,
            imageResId = R.drawable.placeholder_event,
            description = null,
            imageLink = null,
        ),
    )

}

