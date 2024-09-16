package uvg.edu.gt.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.gt.lab5.ui.theme.Lab5Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight


@Composable
fun Concierto(siguiente: () -> Unit, imagen: Painter, nombre: String, descripcion: String, modifier: Modifier = Modifier) {

    Card (modifier = modifier, onClick = siguiente) {
        Column (modifier = Modifier.background(Color(0xfffad9e4))) {
            Image(
                painter = imagen,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = nombre,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .align(alignment = Alignment.Start)
                ,fontWeight = FontWeight.Bold
            )
            Text(
                text = descripcion,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp)
                    .align(alignment = Alignment.Start)
            )
        }
    }
}

@Composable
fun Pagina(siguiente: () -> Unit, modifier: Modifier = Modifier) {
    val icono1 = painterResource(R.drawable.img1)
    val icono2 = painterResource(R.drawable.img2)
    val icono3 = painterResource(R.drawable.img3)
    val icono4 = painterResource(R.drawable.img4)



    Column(modifier = Modifier.fillMaxSize()){
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .background(Color(0xfff2edf6))
            .fillMaxWidth()
            .padding(top = 25.dp, bottom = 10.dp)
            ) {
            Text(text = ("TodoEventos"), fontSize = 24.sp, modifier = Modifier.padding(top = 16.dp, end = 10.dp, start = 25.dp), fontWeight = FontWeight.Bold)
            Icon(
                painter = painterResource(R.drawable.puntitos),
                contentDescription = null,
                modifier = Modifier.size(40.dp).padding(end = 15.dp)
            )
        }
        Text(
            text = "Your favorites",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Row {
            Concierto(siguiente = siguiente, imagen = icono1, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
            Concierto(siguiente = siguiente, imagen = icono2, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
        }
        Row {
            Concierto(siguiente = siguiente, imagen = icono3, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
            Concierto(siguiente = siguiente, imagen = icono4, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
        }
        Row {
            Concierto(siguiente = siguiente, imagen = icono1, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
            Concierto(siguiente = siguiente, imagen = icono1, nombre = "Title", descripcion = "Supporting text", modifier = Modifier
                .weight(1f)
                .padding(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun infoConciertos() {
    Lab5Theme {
        Pagina(siguiente = {})
    }
}