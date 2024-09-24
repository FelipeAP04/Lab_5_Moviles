
package uvg.edu.gt.lab5

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DetalleApp(
    siguiente: () -> Unit,
    modifier: Modifier = Modifier,
    sharedPreferences: SharedPreferences
) {
    var isFavorite by remember { mutableStateOf(sharedPreferences.getBoolean("isFavorite", false)) }

    fun toggleFavorite() {
        isFavorite = !isFavorite
        sharedPreferences.edit().putBoolean("isFavorite", isFavorite).apply()
    }

    val imagen = painterResource(R.drawable.concierto)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xffffffff))
    ) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Title",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 13.dp)
        )
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    painter = painterResource(R.drawable.calendario),
                    contentDescription = null,
                    tint = Color.Gray
                )
                Text(text = "Fecha", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Hora", modifier = Modifier.padding(end = 15.dp), fontSize = 20.sp)
        }
        Text(
            text = "About",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp, bottom = 10.dp)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur\n" +
                    "adipiscing elit. Aliquam sit amet pellentes.\n" +
                    "Lorem ipsum dolor sit amet, consectetur\n" +
                    "adipiscing elit. Aliquam sit amet pellentes.",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)) {
            Button(
                onClick = { toggleFavorite() },
                modifier = Modifier.weight(1f).padding(horizontal = 11.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = if (isFavorite) Color.Yellow else Color(0xffe6def6))
            ) {
                Text(text = if (isFavorite) "Favorited" else "Favorite", color = Color.Black)
            }
            Button(
                onClick = siguiente,
                modifier = Modifier.weight(1f).padding(horizontal = 11.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xffe6def6))
            ) {
                Text(text = "Buy", color = Color.Black)
            }
        }
    }
}


//@Composable
//@Preview
//fun DetallePreview( ) {
//    DetalleApp(
//        siguiente = {  },
//        sharedPreferences = sharedPreferences
//    )
//}