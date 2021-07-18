package com.example.encoratask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.encoratask.models.Character

class CharactersListAdpater(context: Context) :
    GenericRecyclerViewAdapter<Character>(context, null) {
    override fun createView(context: Context, viewGroup: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.characters_list_item, viewGroup, false)
    }

    override fun bindView(item: Character?, position: Int, viewHolder: ViewHolder) {
        item?.let { itm ->
            val imageView = viewHolder.getView<ImageView>(R.id.iv_char_image)
            val textView = viewHolder.getView<TextView>(R.id.tv_char_name)

            with(itm) {
                Glide.with(context)
                    .load(image)
                    .into(imageView)
                textView.text = name
            }
        }
    }

}