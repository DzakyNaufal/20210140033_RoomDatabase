package com.example.roomsiswa

import android.app.Application

class AplikasiSiswa : Application() {
    /**
     * App Container instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}