package com.example.kotlin2lesson6.presentation.ui.fragments.main

import androidx.navigation.NavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson6.R
import com.example.kotlin2lesson6.base.BaseFlowFragment
import com.example.kotlin2lesson6.databinding.FragmentMainFlowBinding
import com.google.android.material.tabs.TabLayout

class MainFlowFragment :
    BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_main_fragment) {
    private val binding by viewBinding(FragmentMainFlowBinding::bind)

    override fun setupNavigation(navController: NavController) {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> navController.navigate(R.id.animeFragment)
                    1 -> navController.navigate(R.id.mangaFragment)

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }

}