package com.example.tradix.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.adapter.NewAdapter
import com.example.tradix.adapter.NewItem


class NewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new, container, false)
        val newAdapter = NewAdapter(requireContext())
        newAdapter.apply {
            listNewItem = listItem
            setClick {
                Toast.makeText(activity, "click item new $it", Toast.LENGTH_SHORT).show()
                    childFragmentManager.beginTransaction()
                        .add(R.id.fragment_holder, EditorialFragment())
                        .addToBackStack(null)
                        .commit()
            }
        }


        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_news)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = newAdapter
        }
        return view
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        val backCallback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                // Remove all fragments from the childFragmentManager,
//                // but exclude the first added child fragment.
//                // This child fragment will be deleted with its parent.
//                if (childFragmentManager.backStackEntryCount > 1) {
//                    childFragmentManager.popBackStack()
//                    return
//                }
//                // Delete parent fragment
//                parentFragmentManager.popBackStack()
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, backCallback)
//    }


    val listItem = mutableListOf<NewItem>(
        NewItem(R.drawable.ic_item_new, "ALT -3%", "3 Sept 2020", "ALANTIA", R.string.text_disc),
        NewItem(R.drawable.ic_item_new_2, "HKD -2,13%", "2 Sept 2020", "XIAOMI", R.string.text_disc),
        NewItem(R.drawable.ic_item_new_3, "AAPL -0,91%", "1 Sept 2020", "APPlE", R.string.text_disc),
        NewItem(R.drawable.ic_item_new, "ALT -387%", "3 Sept 2022", "ALANTIA", R.string.text_disc),
        NewItem(R.drawable.ic_item_new_2, "ALT -387%", "3 Sept 2023", "ALANTIA", R.string.text_disc),
        NewItem(R.drawable.ic_item_new_3, "ALT -387%", "3 Sept 2024", "ALANTIA", R.string.text_disc),
        NewItem(R.drawable.ic_item_new_2, "ALT -387%", "3 Sept 2025", "ALANTIA", R.string.text_disc)
    )
}