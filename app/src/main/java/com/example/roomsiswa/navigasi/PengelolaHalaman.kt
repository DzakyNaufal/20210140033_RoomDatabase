package com.example.roomsiswa.navigasi

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SiswaApp(navController: NavController= rememberNavController()){
    HostNavigasi(navController = navController)
}