package com.example.apidogs.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.apidogs.R
import com.example.apidogs.databinding.ActivityDogImageBinding
import com.example.apidogs.model.data.Dog
import com.example.apidogs.viewmodel.DogImageViewModel
import com.example.apidogs.viewmodel.DogViewModel
import com.squareup.picasso.Picasso
import org.json.JSONObject
import kotlin.random.Random

class DogImageActivity : AppCompatActivity() {

    private val viewModel: DogImageViewModel by viewModels()
    private lateinit var binding:ActivityDogImageBinding

    companion object{
        const val DOG_NAME = "dogName"
        const val DOG_IMAGE_URL = "dogImageUrl"
        const val DOG_DESCRIPTION = "dogDescription"
        const val T_VIEW_DESCRIPTION_DOG = "tViewDescriptionDog"
    }

    private var dogImageUrl = ""
    private var dogName = ""
    private var dogDescription = ""
    private var tViewDescriptionDog = ""

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDogImageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        initBundle()
        initView()
        listeners()
    }

    private fun listeners() {
        binding.backButton.setOnClickListener {
            finish() // Cierra la actividad y vuelve a la anterior
        }

        binding.changeImageButton.setOnClickListener {
            val urls = readImageUrlsFromJson() // Lee las URLs del JSON
            if (urls.isNotEmpty()) {
                val randomIndex = Random.nextInt(urls.size) // Selecciona un índice aleatorio
                val randomImageUrl = urls[randomIndex] // Obtiene una URL aleatoria

            }
        }
        binding.btnUpdateChanges.setOnClickListener {
            saveDogDescription()
            Toast.makeText(getApplicationContext(), "Datos actualizados corréctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        //Detecta cuando el usuario escribe en el EditText
        binding.descriptionDog.addTextChangedListener { text ->
            Log.d("Raul", text.toString())
        }
    }

    private fun initView() {
        // Usa Picasso para cargar la imagen aleatoria
        Picasso.get().load(dogImageUrl).into(binding.dogImageView)
        binding.dogName.text = dogName
        binding.tViewDescriptionDog.text = dogDescription
    }

    private fun initBundle() {
        //Con esto nos aseguramos que todo lo que metemos dentro no va a ser nulo de putExtras del Main
        val bundle = intent.extras
        bundle?.let {
            dogImageUrl = it.getString(DOG_IMAGE_URL,"")
            dogName = it.getString(DOG_NAME,"")
            dogDescription = it.getString(DOG_DESCRIPTION,"")
            tViewDescriptionDog = it.getString(T_VIEW_DESCRIPTION_DOG,"")
        }
    }

    private fun saveDogDescription() {
        val newDescription = binding.descriptionDog.text.toString()

        if(newDescription.isNotEmpty()){
            dogDescription = newDescription
        }

        //Se pasa la descripcion del perro a el texview
        binding.tViewDescriptionDog.setText((dogDescription))
        binding.descriptionDog.setText("")
        viewModel.updateDog(Dog(dogName,dogImageUrl,dogDescription ))

    }


    // Método para leer el archivo JSON y devolver una lista de URLs de imágenes
    fun readImageUrlsFromJson(): List<String> {
        val jsonText = assets.open("dog_images.json").bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonText)
        val jsonArray = jsonObject.getJSONArray("images")

        val urls = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            val url = jsonArray.getString(i)
            urls.add(url)
        }
        return urls
    }
}
