package com.example.roomsiswa.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.roomsiswa.Repository.RepositoriSiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(private val RepositoriSiswa: RepositoriSiswa, it: Any): ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = RepositoriSiswa.getAllSiswaStream().filterNotNull()

        .map { HomeUiState(listSiswa = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

}