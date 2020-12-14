package com.dacodes.myapplication.cocktailModule

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dacodes.myapplication.base.BaseViewModel
import com.dacodes.myapplication.base.ListItemHolder
import com.dacodes.myapplication.extensions.setImageCircularFrom
import kotlinx.android.synthetic.main.layout_cocktail_item.view.*

class CocktailItemViewHolder(val view: View, val context: Activity) : RecyclerView
.ViewHolder(view), ListItemHolder {

    private lateinit var viewModel: CocktailItemViewModel

    override fun setup(itemViewModel: BaseViewModel) {
        viewModel = itemViewModel as CocktailItemViewModel

        view.cocktailItemNameTextView.text = viewModel.name

        view.cocktailItemDescriptionTextView.text = viewModel.description

        view.cocktailItemImageView.setImageCircularFrom(viewModel.image, null)
    }


}