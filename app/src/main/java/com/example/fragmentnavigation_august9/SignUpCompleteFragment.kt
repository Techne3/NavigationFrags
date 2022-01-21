package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.fragmentnavigation_august9.databinding.UserItemBinding

class SignUpCompleteFragment : Fragment() {

    private val args: SignUpCompleteFragmentArgs by navArgs()

    private var _binding: UserItemBinding? = null
    private val binding: UserItemBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        with(binding) {
            nameTv.text = args.firstName
            lastNameTv.text = args.lastName
            emailTv.text = args.email
            passwordTv.text = args.password

            val users = User(firstName = args.firstName, lastName = args.lastName, email = args.email, password = args.password)

            viewModel.addUser(users)


            backBtn.setOnClickListener{
                val directions =
                    SignUpCompleteFragmentDirections.actionSignUpCompleteFragmentToNameFragment()

                findNavController().navigate(directions)

            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}