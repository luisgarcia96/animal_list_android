package com.animals.safety.adapter

import androidx.recyclerview.widget.RecyclerView
import com.animals.safety.adapter.AnimalCardAdapter.AnimalViewHolder
import com.animals.safety.data.Animal

abstract class RefreshableAdapter<T : AnimalViewHolder?> : RecyclerView.Adapter<T>() {
  
  protected var data = mutableListOf<Animal>()
  
  fun refresh(data: List<Animal>) {
    this.data.clear()
    this.data.addAll(data)
    notifyDataSetChanged()
  }
  
}
