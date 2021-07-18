package com.example.encoratask

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.encoratask.extensions.observe
import com.example.encoratask.models.Character
import com.example.encoratask.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
@AndroidEntryPoint
class ItemDetailActivity : AppCompatActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(findViewById(R.id.detail_toolbar))

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        observe(viewModel.character, ::observeCharacter)

        if (savedInstanceState == null) {
            val id = intent.getIntExtra(ItemDetailFragment.ARG_ITEM_ID, 0)
            viewModel.getCharacter(id)

        }
    }


    fun observeCharacter(character: Character) {
        val fragment = ItemDetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(
                    ItemDetailFragment.ARG_ITEM_ID,
                    character
                )
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.item_detail_container, fragment)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}