package com.example.xmlnavapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlnavapp2.databinding.FragmentABinding
import com.example.xmlnavapp2.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: FragmentBArgs by navArgs()
        binding.tvFragB.text = safeArgs.userName

        binding.recyclerView.layoutManager = LinearLayoutManager(this.activity)

        val items = listOf(
            User("Uzair1", 1),
            User("Uzair2", 2),
            User("Uzair3", 3),
            User("Uzair4", 4),
            User("Uzair5", 5),
            User("Uzair6", 6),
            User("Uzair7", 7),
            User("Uzair8", 8),
            User("Uzair9", 9),
            User("Uzair10", 10),
            User("Uzair1", 1),
            User("Uzair2", 2),
            User("Uzair3", 3),
            User("Uzair4", 4),
            User("Uzair5", 5),
            User("Uzair6", 6),
            User("Uzair7", 7),
            User("Uzair8", 8),
            User("Uzair9", 9),
            User("Uzair10", 10),
        )

        val adapter = UserAdapter(items)
        binding.recyclerView.adapter = adapter

    }

}