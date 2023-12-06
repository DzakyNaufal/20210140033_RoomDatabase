package com.example.roomsiswa.Model

import androidx.lifecycle.ViewModel
import com.example.roomsiswa.Repository.RepositoriSiswa

class HomeViewModel(private val RepositorySiswa: RepositoriSiswa, it: Any): ViewModel(){

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}