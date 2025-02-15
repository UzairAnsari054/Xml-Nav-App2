package com.example.xmlnavapp2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.xmlnavapp2.databinding.FragmentABinding


class FragmentA : Fragment(), MenuProvider {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    private val saveStateHandleViewModel: SaveStateHandleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner)

        binding.btnNavWithDestination.setOnClickListener {
            findNavController().navigate(R.id.fragmentB)
        }

        binding.btnNavWithAction.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
        }

        binding.btnNavWithSafeArgs.setOnClickListener {
            findNavController().navigate(FragmentADirections.actionFragmentAToFragmentB(userName = "Uzair"))
        }

        binding.btnNavToActivityB.setOnClickListener {
            val intent = Intent(requireActivity(), BActivity::class.java)
            intent.putExtra("key", "Hello Uzair from Fragment A of Activity A")
            startActivity(intent)
        }

        binding.btnNavToActivityBWithParcelizeDataClass.setOnClickListener {
            val user = User("XYZ", 101)
            val intent = Intent(requireContext(), BActivity::class.java)
            intent.putExtra("USER_KEY", user)
            startActivity(intent)
        }

        binding.btnForEd.setOnClickListener {
            saveStateHandleViewModel.name = binding.edText.text.toString()
        }

        saveStateHandleViewModel.name.let {
            binding.edText.setText(it)
        }

        saveStateHandleViewModel.counter.observe(viewLifecycleOwner, {
            binding.counterTv.text = "$it"
        })

        binding.counterBtn.setOnClickListener {
            saveStateHandleViewModel.updateCounter()
        }


    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.option_menu, menu)


        // TO WRITE IN FRAGMENT B
//        val fragmentBMenuItem = menu.findItem(R.id.option_menu_action_fragmentB)
//        if (fragmentBMenuItem != null) {
//            fragmentBMenuItem.isVisible = false
//        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.option_menu_action_fragmentB -> {
                findNavController().navigate(R.id.fragmentB)
                true
            }

            R.id.option_menu_action_fragmentC -> {
                findNavController().navigate(R.id.fragmentC)
                true
            }

            R.id.option_menu_action_fragmentD -> {
                findNavController().navigate(R.id.fragmentD)
                true
            }

            else -> false
        }
    }

}