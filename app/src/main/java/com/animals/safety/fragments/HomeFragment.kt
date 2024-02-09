package com.animals.safety.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.animals.safety.R
import com.animals.safety.adapter.AnimalCardAdapter
import com.animals.safety.data.AnimalData
import com.animals.safety.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
  
  private var binding: FragmentHomeBinding? = null
  
  private var animalCardAdapter: AnimalCardAdapter? = null
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding?.root
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    animalCardAdapter = AnimalCardAdapter(AnimalData.animals) { animal ->
      val bundle = Bundle().apply {
        putSerializable(DetailsFragment.KEY_ANIMAL, animal)
      }
      
      NavHostFragment.findNavController(this@HomeFragment)
        .navigate(R.id.action_HomeFragment_to_DetailsFragment, bundle)
    }
    binding?.recyclerView?.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = animalCardAdapter
      addItemDecoration(
        DividerItemDecoration(
          context,
          DividerItemDecoration.VERTICAL
        )
      )
    }
    
    binding?.fab?.setOnClickListener {
      NavHostFragment.findNavController(this@HomeFragment)
        .navigate(R.id.action_HomeFragment_to_CreateFragment)
    }
  }
  
  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
  
}
