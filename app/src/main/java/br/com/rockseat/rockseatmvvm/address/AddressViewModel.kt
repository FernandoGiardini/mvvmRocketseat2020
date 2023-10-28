package br.com.rockseat.rockseatmvvm.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rockseat.rockseatmvvm.service.BrasilApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddressViewModel(
    private val service: BrasilApiService
):ViewModel() {

    val liveData = MutableLiveData<Address>()

    fun getAddress(cep:String){

        viewModelScope.launch(Dispatchers.IO) {

            val result:Address =  service.getAddressByCep(cep)

            liveData.postValue(result)
        }

    }

}