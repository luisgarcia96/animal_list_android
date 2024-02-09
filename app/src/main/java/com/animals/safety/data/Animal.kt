package com.animals.safety.data

import java.io.Serializable

data class Animal(
  val name: String,
  val breed: Breed,
  val age: Int,
  val weight: Float,
  val height: Float
) : Serializable
