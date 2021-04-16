package com.adnanabouelenein.boldic.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.adnanabouelenein.boldic.R

class OnBoardingTwoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding_two, container, false)
        val nextToOnBoardTwo = view.findViewById<Button>(R.id.next_to_on_board_three)
        nextToOnBoardTwo.setOnClickListener { v -> Navigation.
        findNavController(v)
                .navigate(R.id.action_onBoardingTwoFragment_to_onBoardingThreeFragment) }
        return view
    }
}