package uvg.edu.gt.lab5.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import uvg.edu.gt.lab5.R

data class Conciertos(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title : Int,
    @StringRes val description: Int,
    val favoritos: Boolean
)

val sharedPreferences: Boolean = false
val conciertos = listOf(
    Conciertos(R.drawable.concierto, R.string.concierto, R.string.concierto_desc, sharedPreferences),
    Conciertos(R.drawable.soad, R.string.soad, R.string.Soad_desc, sharedPreferences),
    Conciertos(R.drawable.pilots, R.string.pilots, R.string.pilots_desc, sharedPreferences),
    Conciertos(R.drawable.deftones, R.string.deftones, R.string.deftones_desc, sharedPreferences),
    Conciertos(R.drawable.alan, R.string.alan, R.string.alan_desc, sharedPreferences),
    Conciertos(R.drawable.ado, R.string.ado, R.string.ado_desc, sharedPreferences)

)
