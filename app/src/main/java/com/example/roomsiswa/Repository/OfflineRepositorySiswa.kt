package com.example.roomsiswa.Repository

import com.example.roomsiswa.Data.Siswa
import com.example.roomsiswa.Data.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriSiswa (private val siswaDao: SiswaDao): RepositoriSiswa{
    override fun getAllSiswaStream(): Flow<List<Siswa>> {
        return siswaDao.getAllSiswa()
    }

    override fun getSiswaStream(id: Int): Flow<Siswa?> {
        return siswaDao.getSiswa(id)
    }

    override suspend fun insertSiswa(siswa: Siswa) {
        siswaDao.insert(siswa)
    }

    override suspend fun deleteSiswa(siswa: Siswa) {
        siswaDao.delete(siswa)
    }

    override suspend fun updateSiswa(siswa: Siswa) {
        siswaDao.update(siswa)
    }
}