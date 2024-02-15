package com.example.apidogs.view

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apidogs.R
import com.example.apidogs.model.data.Dog
import com.example.apidogs.model.data.DogList

class DogAdapter(dogList: DogList, private val onItemClick: (Dog) -> Unit) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {
        private var dogListAux = DogList()
        private var dogListOrigin = DogList()
        private var listFilter: DogList
        private var listOrigin: DogList
        init {
            dogListOrigin.dogList.addAll(dogList.dogList)
            dogListAux.dogList.addAll(dogList.dogList)
            listOrigin = dogListOrigin
            listFilter = dogListAux
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        return DogViewHolder(itemView, onItemClick)

    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val currentDog = listFilter.dogList[position]
        holder.bind(currentDog)
        holder.itemView.setOnClickListener {
            onItemClick(currentDog)
        }
    }

    override fun getItemCount(): Int = listFilter.dogList.size

    fun updateDogsList(newDogList: List<Dog>) {
        listFilter.dogList.apply {
            clear()
            addAll(newDogList)
        }
        notifyDataSetChanged()

    }

    fun getDogList() = listOrigin.dogList
    fun refresList(perrosAux: DogList?) {


    }

    class DogViewHolder(itemView: View, private val onItemClick: (Dog) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val dogName: TextView = itemView.findViewById(R.id.dogName)

        fun bind(dog: Dog) {
            dogName.text = dog.name
            itemView.setOnClickListener { onItemClick(dog) }
        }
    }
}
