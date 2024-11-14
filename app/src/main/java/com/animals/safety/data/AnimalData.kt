package com.animals.safety.data

import com.animals.safety.R
import java.util.UUID

  object AnimalData {

    private val milou = Animal(
      id = UUID.randomUUID(),
      name = "Milou",
      breed = Breed.DOG,
      age = 6,
      weight = 23.2f,
      height = 42.4f,
      imageResId = R.drawable.img_dog
    )

    private val rantanplan = Animal(
      id = UUID.randomUUID(),
      name = "Rantanplan",
      breed = Breed.DOG,
      age = 8,
      weight = 28.1f,
      height = 38.4f,
      imageResId = R.drawable.img_dog
    )

    private val garfield = Animal(
      id = UUID.randomUUID(),
      name = "Garfield",
      breed = Breed.CAT,
      age = 12,
      weight = 5.4f,
      height = 21.3f,
      imageResId = R.drawable.img_cat
    )

    private val marguerite = Animal(
      id = UUID.randomUUID(),
      name = "Marguerite",
      breed = Breed.COW,
      age = 3,
      weight = 668.3f,
      height = 148f,
      imageResId = R.drawable.img_cow
    )

    val animals = mutableListOf(milou, rantanplan, garfield, marguerite)

    fun findAnimalById(animalId: String): Animal =
      animals.first { it.id.toString() == animalId }

  }


