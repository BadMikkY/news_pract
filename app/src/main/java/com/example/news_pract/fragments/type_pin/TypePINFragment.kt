package com.example.news_pract.fragments.type_pin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.news_pract.R


class TypePINFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.fragment_type_p_i_n, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.confirm_button).setOnClickListener{
            findNavController().navigate(R.id.action_typePINFragment_to_latestNewsFragment)
        }
        view.findViewById<Button>(R.id.skip_button).setOnClickListener{
            findNavController().navigate(R.id.action_typePINFragment_to_latestNewsFragment)
        }
    }


}