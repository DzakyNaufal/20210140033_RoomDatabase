package com.example.roomsiswa.model

import android.app.AlarmManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomsiswa.Data.Siswa
import com.example.roomsiswa.Repository.RepositoriSiswa
import java.util.NavigableMap

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    /*
    * Berisi status siswa saat ini
    */
    var  uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk menvalidasi imput */
    private fun validasiInput (uiState: DetailSiswa = uiStateSiswa.detailSiswa) : Boolean{
        return  with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /*Fungsi Untuk menyimpan data yang di-entry */
    suspend fun saveSiswa(){
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

