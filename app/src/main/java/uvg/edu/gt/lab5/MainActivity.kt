package uvg.edu.gt.lab5

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import uvg.edu.gt.lab5.ui.theme.Lab5Theme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Lab5Screen (@StringRes val title: Int) {
    Perfil (title = R.string.perfil),
    Lugares (title = R.string.lugares),
    Favoritos (title = R.string.favoritos),
    Detalle (title = R.string.detalle)
}

class MainActivity : ComponentActivity() {
    companion object {
        const val PREFS_NAME = "FavoritePrefs"
        const val FAVORITE_KEY = "isFavorite"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lab5App(getSharedPreferences(PREFS_NAME, MODE_PRIVATE))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentScreen: Lab5Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(painter = painterResource(R.drawable.flecha), contentDescription = null)
                }
            }
        }
    )
}

@Composable
fun Lab5App(
    sharedPreferences: SharedPreferences
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Lab5Screen.valueOf(
        backStackEntry?.destination?.route ?: Lab5Screen.Perfil.name
    )

    Scaffold(
        topBar = {
            AppTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Lab5Screen.Perfil.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Lab5Screen.Perfil.name) {
                PerfilApp(
                    siguiente = { navController.navigate(Lab5Screen.Favoritos.name) }
                )
            }
            composable(route = Lab5Screen.Favoritos.name) {
                Pagina(
                    siguiente = { navController.navigate(Lab5Screen.Detalle.name) }
                )
            }
            composable(route = Lab5Screen.Detalle.name) {
                DetalleApp(
                    siguiente = { navController.navigate(Lab5Screen.Lugares.name) },
                    sharedPreferences = sharedPreferences
                )
            }
            composable(route = Lab5Screen.Lugares.name) {
                LugaresApp()
            }
        }
    }
}
