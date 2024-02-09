package com.animals.safety.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.animals.safety.adapter.AnimalCardAdapter.AnimalViewHolder
import com.animals.safety.data.Animal
import com.animals.safety.databinding.ItemAnimalBinding

class AnimalCardAdapter(data: List<Animal>, val clickListener: OnAnimalClickListener) :
  RefreshableAdapter<AnimalViewHolder?>() {
  
  init {
    refresh(data)
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
    return AnimalViewHolder(
      ItemAnimalBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }
  
  override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
    val animal = data[position]
    holder.itemView.setOnClickListener { clickListener.onClick(animal) }
    
    //TODO

//    DecimalFormat df = new DecimalFormat();
//    df.setMaximumFractionDigits(2);
//
//    holder.binding.avatar.setImageDrawable(
//      AppCompatResources.getDrawable(
//        holder.itemView.getContext(),
//        animal.getBreed().getCover()
//      )
//    );
//    holder.binding.name.setText(animal.getName());
//    String breedName = StringUtils . capitalize (holder.itemView.getContext()
//      .getString(animal.getBreed().getTranslatedName()));
//    holder.binding.information.setText(
//      holder.itemView
//        .getContext()
//        .getString(
//          R.string.information,
//          breedName,
//          animal.getAge(),
//          df.format(animal.getWeight()),
//          df.format(animal.getHeight())
//        )
//    );
  
  }
  
  override fun getItemCount(): Int {
    return data.size
  }
  
  class AnimalViewHolder(binding: ItemAnimalBinding) : RecyclerView.ViewHolder(
    binding.root
  )
  
}
