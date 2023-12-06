package com.example.roomsiswa.Model

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
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

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 *  [AplikasiSiswa]
 */
fun CreationExtras.AplikasiSiswa():AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)