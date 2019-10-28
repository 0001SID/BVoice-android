package com.example.multiscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FixedTabFragmentPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 4
    }

    //Provide informatin tab show which fragment

    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> NumbersFragment()
            1-> ColorsFragment()
            2-> FamilyFragment()
            3-> PhrasesFragment()
            else -> Fragment()
        }
    }

    //Creating tabs name

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Numbers"
            1-> "Colors"
            2-> "Family"
            3-> "Phrases"
            else -> null
        }

    }
}