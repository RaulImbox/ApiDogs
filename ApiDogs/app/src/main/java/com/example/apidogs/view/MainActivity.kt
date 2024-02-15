package com.example.apidogs.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.apidogs.databinding.ActivityMainBinding
import com.example.apidogs.model.data.Dog
import com.example.apidogs.model.data.DogList
import com.example.apidogs.viewmodel.DogViewModel

class MainActivity : AppCompatActivity() {

    //Declaramos una variable tipo RecyclerView y DogAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var dogAdapter: DogAdapter
    private val viewModel: DogViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    companion object{
        var perrosAux: DogList? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }

    override fun onResume() {
        super.onResume()
        perrosAux?.let {
            dogAdapter.updateDogsList(it.dogList)
        }
    }
    private fun showMessage(text: String){
        Log.i("Raul", text)
    }

    private fun aux (dog: Dog){
        showMessage(dog.imageUrl)
        val intent = Intent(this, DogImageActivity::class.java).apply {
            putExtra(DogImageActivity.DOG_NAME, dog.name)
            putExtra(DogImageActivity.DOG_IMAGE_URL, dog.imageUrl)
            putExtra(DogImageActivity.DOG_DESCRIPTION, dog.description)

        }
        startActivity(intent)
    }

    private fun setUp(){
        getDogs()
        // Observa el LiveData desde el ViewModel
        viewModel.dogs.observe(this) { dogs ->
            if(perrosAux == null){
                perrosAux = dogs

            }

            // Actualiza el adaptador con los nuevos datos
            binding.progressBar.visibility = View.GONE
            // Inicializa el adaptador con la lista de perros vacia
            dogAdapter = DogAdapter(perrosAux?: DogList()) { dog ->
                aux(dog)
            }
            binding.recyclerView.adapter = dogAdapter
        }
        listeners()
    }

    private fun listeners() {
        binding.etxtFilter.addTextChangedListener { dogFilter ->
            val listFilter = mutableListOf<Dog>()
            listFilter.addAll(
                perrosAux?.dogList ?: listOf()
            )
            var dogFiltered = listFilter.filter { dog -> dog.name.contains(dogFilter.toString())  }

            if(dogFilter.toString().isEmpty()){
                dogFiltered = perrosAux?.dogList ?: listOf()
            }

            dogAdapter.updateDogsList(dogFiltered)
        }
    }

    private fun getDogs(){
        viewModel.getAllDogs()
    }
}
