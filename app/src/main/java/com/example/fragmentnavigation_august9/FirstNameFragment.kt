package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation_august9.databinding.FragmentFirstNameBinding

class FirstNameFragment : Fragment() {

    private var _binding: FragmentFirstNameBinding? = null
    private val binding: FragmentFirstNameBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            nextBtn
                .setOnClickListener {
                    val firstName = nameEt.editText?.text.toString()
                    val lastName = lastNameEt.editText?.text.toString()

                    val direction =
                        NameFragmentDirections.nameFragmentToPasswordFragmentAction(
                            firstName,
                            lastName
                        )
                    findNavController().navigate(direction)
                }
        }

    }

}