package com.example.news_pract.presentation.fragments.type_pin

import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.news_pract.App
import com.example.news_pract.R
import com.example.news_pract.data.UsersRepository
import com.example.news_pract.databinding.FragmentTypePINBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TypePINFragment : Fragment() {

    private var _binding: FragmentTypePINBinding? = null
    private val binding get() = _binding!!
    val typePinViewModel by viewModels<TypePinViewModel> { TypePinViewModelFactory((activity?.application as App).usersRepository) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTypePINBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            typePinViewModel.uiState.collect { state ->
                if (state.isLoggedIn == false) {
                    findNavController().navigate(R.id.action_typePINFragment_to_latestNewsFragment)
                }
                if (state.navigateToNews) {
                    findNavController().navigate(R.id.action_typePINFragment_to_latestNewsFragment)
                }
                if(!state.showSkipButton){
                    binding.skipButton.isVisible = false
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            typePinViewModel.singleToastEvent.collect{message ->
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
            }
        }

        typePinViewModel.isLoggedIn()

        binding.message.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    typePinViewModel.onCodeChanged(s.toString())
                }
            }
        })




        binding.confirmButton.setOnClickListener {
            typePinViewModel.onConfirmClick()
        }

        binding.skipButton.setOnClickListener {
            typePinViewModel.skipPin()
            findNavController().navigate(R.id.action_typePINFragment_to_latestNewsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}