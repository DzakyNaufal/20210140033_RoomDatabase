package com.example.roomsiswa.Model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsiswa.Repository.RepositoriSiswa
import com.example.roomsiswa.model.DetailSiswa
import com.example.roomsiswa.model.toSiswa
import com.example.roomsiswa.ui.theme.Halaman.DetailDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    private val siswaId: Int = checkNotNull(savedStateHandle[DetailDestination.siswaIdArg])
    val uiState: StateFlow<ItemDetailUiState> =
        repositoriSiswa.getAllSiswaStream(siswaId)
            .filterNotNull()
            .map { ItemDetailUiState(detailSiswa = it.toDetailSiswa())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_KILLIS),
                initialValue = ItemDetailUiState()
            )

    suspend fun detailItem() {
        repositoriSiswa.deleteSiswa(uiState.value.detailSiswa.toSiswa())
    }

    companion object{
        private const val TIMEOUT_KILLIS = 5_000L
    }

}

data class ItemDetailUiState(
    val outOfStock: Boolean = true,
    val detailSiswa: DetailSiswa = DetailSiswa(),
)