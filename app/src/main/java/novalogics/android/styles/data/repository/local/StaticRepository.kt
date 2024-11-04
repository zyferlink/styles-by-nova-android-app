package novalogics.android.styles.data.repository.local

import android.content.Context
import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.Event
import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.type.FashionCategory

object StaticRepository {

    fun getWomenEvents(context: Context): List<EventEntity> {
        return listOf(
            EventEntity(
                id = 1000,
                name = context.getString(R.string.twilight_elegance),
                eventCategory = context.getString(R.string.evening),
                fashionCategory = FashionCategory.WOMEN,
                imageResId = R.drawable.event_women_evening,
                description = null,
                imageLink = null,
            ),
        )
    }


}
