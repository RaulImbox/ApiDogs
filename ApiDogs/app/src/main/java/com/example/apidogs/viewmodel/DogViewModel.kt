package com.example.apidogs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apidogs.model.data.Dog
import com.example.apidogs.model.data.DogList
import com.example.apidogs.model.data.DogsProvider

class DogViewModel : ViewModel() {
    private val _dogs = MutableLiveData<DogList>()
    val dogs: LiveData<DogList> = _dogs

    fun getAllDogs() {
        _dogs.value = DogsProvider().getAllDogs()
    }
}
