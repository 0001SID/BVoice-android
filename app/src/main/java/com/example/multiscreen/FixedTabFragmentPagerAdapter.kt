package com.example.multiscreen

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/*
 * In FixedTabFragmentPagerAdapter we also passing the context(current:Context) of MainActivity to use the resources object for getting
 * the string from strings.xml file without this context resources object is not available in this file
 */

class FixedTabFragmentPagerAdapter(fm:FragmentManager,current: Context):FragmentPagerAdapter(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var context:Context = current

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
            0-> context.resources.getString(R.string.category_numbers)
            1-> context.resources.getString(R.string.category_colors)
            2-> context.resources.getString(R.string.category_family)
            3-> context.resources.getString(R.string.category_phrases)
            else -> null
        }

    }
}