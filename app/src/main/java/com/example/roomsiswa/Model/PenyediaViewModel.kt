package com.example.roomsiswa.Model

import android.text.Spannable.Factory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomsiswa.AplikasiSiswa
import com.example.roomsiswa.model.EntryViewModel

object PenyediaViewModel {
    val Factory =  viewModelFactory {

        initializer {
            HomeViewModel(AplikasiSiswa().container.RepositoriSiswa)
        }
        initializer {
            EntryViewModel(AplikasiSiswa().container.RepositoriSiswa)
        }
    }
}