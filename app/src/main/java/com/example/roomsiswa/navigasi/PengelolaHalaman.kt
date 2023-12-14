package com.example.roomsiswa.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomsiswa.R
import com.example.roomsiswa.ui.theme.Halaman.DestinasiEntry
import com.example.roomsiswa.ui.theme.Halaman.DestinasiHome
import com.example.roomsiswa.ui.theme.Halaman.DetailDestination
import com.example.roomsiswa.ui.theme.Halaman.DetailScreen
import com.example.roomsiswa.ui.theme.Halaman.EntrySiswaScreen
import com.example.roomsiswa.ui.theme.Halaman.HomeScreen
import com.example.roomsiswa.ui.theme.Halaman.ItemEditDestination
import com.example.roomsiswa.ui.theme.Halaman.ItemEditScreen

@Composable
fun SiswaApp(navController: NavHostController= rememberNavController()){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
  navController: NavHostController,
  modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier )
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                    navController.navigate("${DetailDestination.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack()})
        }

        composable(
            DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.siswaIdArg) {
                type = NavType.IntType
            })
        ){
            DetailScreen(
                navigateToEditItem = {
                    navController.navigate("${ItemEditDestination.route}/$it")
                },
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}