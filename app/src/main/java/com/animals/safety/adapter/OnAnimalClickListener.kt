package com.animals.safety.adapter

import com.animals.safety.data.Animal

fun interface OnAnimalClickListener {
  
  fun onClick(animal: Animal?)
  
}
