package com.ggroup.greecle.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggroup.greecle.R

/**
 * A simple [Fragment] subclass.
 * Use the [MapControlFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapControlFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_control, container, false)
    }
}