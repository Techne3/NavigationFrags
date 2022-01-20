package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentnavigation_august9.databinding.EmailFragmentBinding

class EmailFragment : Fragment() {

    private val args: EmailFragmentArgs by navArgs()

    private var _binding: EmailFragmentBinding? = null
    private val binding: EmailFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EmailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            nextBtn.setOnClickListener {
                val email = emailEt.editText?.text.toString()

                val directions =
                 EmailFragmentDirections.actionEmailFragmentToPasswordFragment(
                     args.firstName,
                     args.lastName,
                     email,
                 )

                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


