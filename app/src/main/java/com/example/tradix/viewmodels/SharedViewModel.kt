package com.example.tradix.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tradix.*
import com.example.tradix.model.Model1

class SharedViewModel : ViewModel() {
    private val _listCoin: MutableLiveData<MutableList<Model1?>> = MutableLiveData(
        firstListCoin
    )
    val listCoin: LiveData<MutableList<Model1?>> = _listCoin

    val _curCoinOpenned = MutableLiveData<Int>(0)
    val curCoinOpenned: LiveData<Int> = _curCoinOpenned

    private var lastLoadIndex = firstListCoin.size

    fun loadMoreDataListCoin() {
        val nullIndex = _listCoin.value?.size?.minus(1)
        if (nullIndex != null) {
            _listCoin.value?.removeAt(nullIndex)
        }
        //val scrollPosition = _listCoin.value?.size
        for (i in 1..10) {
            _listCoin.value?.add(
                Model1(
                    "Down fffff Jone ${lastLoadIndex}",
                    "20.047,50",
                    "+203 (+1,04%)",
                    "NYSE",
                    "10:44:45"
                )
            )
            lastLoadIndex++
        }
        _listCoin.value?.add(null)
    }

    fun removeItem(position: Int) {
        _listCoin.value?.removeAt(position)
        //  _lastLoadIndex.value?.minus(1)
    }
}