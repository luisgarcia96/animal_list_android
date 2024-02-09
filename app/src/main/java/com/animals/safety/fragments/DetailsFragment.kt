package com.animals.safety.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.animals.safety.data.Animal
import com.animals.safety.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
  
  private var binding: FragmentDetailsBinding? = null
  
  private val animal: Animal?
    get() = arguments?.getSerializable(KEY_ANIMAL) as Animal?
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDetailsBinding.inflate(inflater, container, false)
    return binding?.root
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    //TODO
//    binding.imageViewAvatar.setImageDrawable(AppCompatResources.getDrawable(getContext(), getAnimal().getBreed().getCover()));
//    binding.textViewName.setText(getAnimal().getName());
//    binding.textViewAge.setText(getString(R.string.value_age, String.valueOf(getAnimal().getAge())));
//    binding.textViewWeight.setText(getString(R.string.value_weight, String.valueOf(getAnimal().getWeight())));
//    binding.textViewHeight.setText(getString(R.string.value_height, String.valueOf(getAnimal().getHeight())));
  
  }
  
  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
  
  companion object {
    const val KEY_ANIMAL = "ANIMAL"
  }
  
}
