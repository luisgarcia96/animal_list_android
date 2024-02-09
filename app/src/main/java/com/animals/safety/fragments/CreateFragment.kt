package com.animals.safety.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.animals.safety.data.Breed
import com.animals.safety.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {
  
  private var binding: FragmentCreateBinding? = null
  
  private val breeds: List<String>
    get() {
      val result = ArrayList<String>()
      
      for (breed in Breed.entries) {
        result.add(breed.name)
      }
      
      return result
    }
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentCreateBinding.inflate(inflater, container, false)
    return binding?.root
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    //TODO
//    binding.numberpickerBreed.setMinValue(1);
//    binding.numberpickerBreed.setMaxValue(getBreeds().size());
//    binding.numberpickerBreed.setValue(1);
//    binding.numberpickerBreed.setWrapSelectorWheel(false);
//    binding.numberpickerBreed.setDisplayedValues(getBreeds().toArray(new String [0]));
//
//    binding.fab.setOnClickListener(new View . OnClickListener () {
//      @Override
//      public void onClick(View view) {
//        if (verifyAndCreateAnimal())
//          NavHostFragment.findNavController(CreateFragment.this).navigateUp();
//      }
//    });
  
  }
  
  //TODO
//  private boolean verifyAndCreateAnimal()
//  {
//    String name = binding . fieldName . getText ().toString();
//    if (name.isBlank()) {
//      Snackbar.make(
//        getView(),
//        "The name must not be empty",
//        Snackbar.LENGTH_LONG
//      ).setAnchorView(R.id.fab).show();
//      return false;
//    }
//
//    Breed breed = Breed . values ()[binding.numberpickerBreed.getValue() - 1];
//
//    int age;
//    try {
//      age = Integer.parseInt(binding.fieldAge.getText().toString());
//    } catch (NumberFormatException e) {
//      Snackbar.make(
//        getView(),
//        "The age is not valid",
//        Snackbar.LENGTH_LONG
//      ).setAnchorView(R.id.fab).show();
//      return false;
//    }
//
//    float weight;
//    try {
//      weight = Float.parseFloat(binding.fieldWeight.getText().toString());
//    } catch (NumberFormatException e) {
//      Snackbar.make(
//        getView(),
//        "The weight is not valid",
//        Snackbar.LENGTH_LONG
//      ).setAnchorView(R.id.fab).show();
//      return false;
//    }
//
//    float height;
//    try {
//      height = Float.parseFloat(binding.fieldHeight.getText().toString());
//    } catch (NumberFormatException e) {
//      Snackbar.make(
//        getView(),
//        "The height is not valid",
//        Snackbar.LENGTH_LONG
//      ).setAnchorView(R.id.fab).show();
//      return false;
//    }
//
//    AnimalData.animals.add(
//      new Animal (
//          name,
//      breed,
//      age,
//      weight,
//      height
//    ));
//
//    return true;
//  }
  
  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
  
}
