package uvg.edu.gt.lab5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.gt.lab5.ui.theme.Lab5Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import uvg.edu.gt.lab5.data.conciertos

@Composable
fun Concierto(siguiente: () -> Unit, imagen : Painter, nombre: String, descripcion: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier, onClick = siguiente) {
        Column(modifier = Modifier.background(Color(0xfffad9e4))) {
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
                    .align(alignment = Alignment.Start),
                fontWeight = FontWeight.Bold
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
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "All Concerts",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(conciertos) { concierto ->
                Concierto(
                    siguiente = siguiente,
                    imagen = painterResource(concierto.imageResourceId),
                    nombre = stringResource(concierto.title),
                    descripcion = stringResource(concierto.description),
                    modifier = Modifier
                        .size(width = 200.dp, height = 250.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoConciertos() {
    Lab5Theme {
        Pagina(siguiente = {})
    }
}
