package com.example.encoratask

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.encoratask.extensions.observe
import com.example.encoratask.models.Character
import com.example.encoratask.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
@AndroidEntryPoint
class ItemListActivity : AppCompatActivity() {

    private val viewModel: CharactersViewModel by viewModels()
    lateinit var adapter: CharactersListAdpater

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        adapter = CharactersListAdpater(this)

        observe(viewModel.characters, ::observeCharactersList)
        viewModel.getCharacters()

        setupRecyclerView(findViewById(R.id.item_list))
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = this.adapter
        adapter.setClickListener (object: GenericRecyclerViewAdapter.OnViewHolderClickListener<Character> {
            override fun onClick(view: View, position: Int, item: Character?) {
                item?.let {
                    val intent = Intent(this@ItemListActivity, ItemDetailActivity::class.java)
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, it.id)
                    startActivity(intent)
                }
            }
        })
    }

    private fun observeCharactersList(characters: List<Character>) {
        adapter.setNewContent( characters)
    }
}