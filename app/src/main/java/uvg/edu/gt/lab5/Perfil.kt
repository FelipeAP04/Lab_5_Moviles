package uvg.edu.gt.lab5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PerfilApp(
    siguiente: () -> Unit,
    modifier: Modifier = Modifier
) {
    val imagen = painterResource(R.drawable.fondo)
    val perfil = painterResource(R.drawable.perfil)
    val triangulo = painterResource(R.drawable.triangulo)
    val noti = painterResource(R.drawable.toggle)
    Column (modifier = modifier
        .fillMaxSize()
        .background(Color(0xffffffff))) {
        Box(contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = imagen,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = perfil, contentDescription = null, modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(150.dp))
                Text(
                    text = "Name",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 13.dp)
                )
            }

        }
        Row (modifier = Modifier.padding(vertical = 17.dp, horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            val editar = painterResource(R.drawable.editar)
            Icon(painter = editar, contentDescription = null, tint = Color.Gray)
            Text(text = "Edit Profile", fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = triangulo, contentDescription = null, tint = Color.DarkGray, modifier = Modifier.size(20.dp))
        }
        Row (modifier = Modifier.padding(vertical = 17.dp, horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            val cierre = painterResource(R.drawable.cierre)
            Icon(painter = cierre, contentDescription = null, tint = Color.Gray)
            Text(text = "Reset Password", fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = triangulo, contentDescription = null, tint = Color.DarkGray, modifier = Modifier.size(20.dp))
        }
        Row (modifier = Modifier.padding(vertical = 17.dp, horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            val usuario = painterResource(R.drawable.usuario)
            Icon(painter = usuario, contentDescription = null, tint = Color.Gray)
            Text(text = "Notifications", fontSize = 17.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = noti, contentDescription = null, tint = Color.DarkGray, modifier = Modifier.size(40.dp))

        }
        Card (onClick = siguiente, colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))) {
            Row(
                modifier = Modifier.padding(vertical = 17.dp, horizontal = 10.dp).background(Color(0xFFFFFFFF)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val star = painterResource(R.drawable.star_24dp_e8eaed_fill1_wght400_grad0_opsz24)
                Icon(painter = star, contentDescription = null, tint = Color.Gray)
                Text(text = "Favorites", fontSize = 17.sp)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = triangulo,
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }

}

@Composable
@Preview
fun PerfilPreview() {
    PerfilApp(siguiente = {})
}