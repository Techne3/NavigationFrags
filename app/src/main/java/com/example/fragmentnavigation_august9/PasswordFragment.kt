package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentnavigation_august9.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {

    private val args: PasswordFragmentArgs by navArgs()


    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            nextBtn.setOnClickListener {
                val password = passwordEt.editText?.text.toString()

                val directions =
                    PasswordFragmentDirections.actionPasswordFragmentToSignUpCompleteFragment(
                        args.firstName,
                        args.lastName,
                        args.email,
                        password
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