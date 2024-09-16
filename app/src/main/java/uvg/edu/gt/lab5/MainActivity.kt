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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uvg.edu.gt.lab5.ui.theme.Lab5Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Lab5Screen {
    Perfil,
    Lugares,
    Favoritos,
    Detalle
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    Lab5App()
            }
        }
    }
}
}

@Composable
fun Lab5App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Lab5Screen.Perfil.name
    ){
        composable(route = Lab5Screen.Perfil.name){
            PerfilApp(
                siguiente = { navController.navigate(Lab5Screen.Favoritos.name) }
            )
        }
        composable(route = Lab5Screen.Favoritos.name){
            Pagina(
                siguiente = { navController.navigate(Lab5Screen.Detalle.name) }
            )
        }
        composable(route = Lab5Screen.Detalle.name){
            DetalleApp(
                siguiente = { navController.navigate(Lab5Screen.Lugares.name) }
            )
        }
        composable(route = Lab5Screen.Lugares.name){
            LugaresApp()
        }


    }
}