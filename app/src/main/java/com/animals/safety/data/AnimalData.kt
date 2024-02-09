package com.animals.safety.data

object AnimalData {
  
  private val milou = Animal("Milou", Breed.DOG, 6, 23.2f, 42.4f)
  
  private val rantanplan = Animal("Rantanplan", Breed.DOG, 8, 28.1f, 38.4f)
  
  private val garfield = Animal("Garfield", Breed.CAT, 12, 5.4f, 21.3f)
  
  private val marguerite = Animal("Marguerite", Breed.COW, 3, 668.3f, 148f)
  
  val animals = mutableListOf(milou, rantanplan, garfield, marguerite)
  
}

