package com.example.apidogs.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apidogs.model.data.Dog
import com.example.apidogs.view.MainActivity

class DogImageViewModel : ViewModel() {

    //Devuelve de la lista el primer peroo que encuentre con el nombre introducdo
    fun updateDog(newDog: Dog) {
        val dogList = MainActivity.perrosAux
        dogList?.let {
            val position = it.dogList.indexOfFirst { dog -> dog.name == newDog.name }
            if(position != -1){
                it.dogList.set(position,newDog)

            }
        }
    }
}