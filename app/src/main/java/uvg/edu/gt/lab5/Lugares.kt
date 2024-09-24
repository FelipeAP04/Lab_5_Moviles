package uvg.edu.gt.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.gt.lab5.ui.theme.Lab5Theme


@Composable
fun LugaresApp(modifier: Modifier = Modifier){
    Column (modifier = modifier.fillMaxSize()) {
        Eventos(nombre = "Guns and Roses LA", descripcion = "LA Hall")
        Eventos(nombre = "Guns and Roses Denver", descripcion = "Denver Hall")
        Eventos(nombre = "Guns and Roses New York", descripcion = "Madison Square Garden")

    }
}

@Composable
private fun Eventos(nombre: String, descripcion: String, modifier: Modifier = Modifier){
    val perfil = painterResource(R.drawable.perfil)
    val imagen = painterResource(R.drawable.triangulo)
    Row (modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 9.dp), verticalAlignment = Alignment.CenterVertically,) {
        Image (painter = perfil, contentDescription = null, modifier = Modifier.size(50.dp))
        Column {
            Text(text = nombre, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = descripcion, fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(painter = imagen, contentDescription = null, tint = Color.Gray, modifier = Modifier
            .size(34.dp)
            .padding(end = 15.dp))
    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
fun LugaresPreview() {
    Lab5Theme {
        LugaresApp()
    }
}