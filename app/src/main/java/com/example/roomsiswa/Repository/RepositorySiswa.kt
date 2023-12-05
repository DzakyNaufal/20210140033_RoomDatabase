package com.example.roomsiswa.Repository

import com.example.roomsiswa.Data.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    fun getSiswaStream(id: Int): Flow<Siswa?>
    suspend fun insertSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}