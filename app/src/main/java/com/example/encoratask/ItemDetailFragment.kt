package com.example.encoratask

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.encoratask.dummy.DummyContent
import com.example.encoratask.models.Character
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
@AndroidEntryPoint
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = it.getSerializable(ARG_ITEM_ID) as Character
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.name
                val iv = activity?.findViewById<ImageView>(R.id.iv_char_image)
                iv?.let { ivsafe ->
                    Glide.with(requireActivity())
                        .load(item?.image)
                        .into(ivsafe)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.findViewById<TextView>(R.id.tv_char_name).text = "Specie: ${it.species}\nGender: ${it.gender}\nStatus: ${it.status}"
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
        const val ARG_NAME = "name"
    }
}