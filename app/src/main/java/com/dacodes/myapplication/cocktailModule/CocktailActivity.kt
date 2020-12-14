package com.dacodes.myapplication.cocktailModule

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dacodes.myapplication.R
import com.dacodes.myapplication.base.BaseActivity
import com.dacodes.myapplication.base.BaseRecyclerViewAdapter
import com.dacodes.myapplication.databinding.CocktailActivityBinding
import com.dacodes.myapplication.utils.Constants
import javax.inject.Inject

class CocktailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: CocktailViewModel

    lateinit var adapter: BaseRecyclerViewAdapter

    lateinit var binding: CocktailActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CocktailActivityBinding.inflate(layoutInflater)
        val view = binding.root

        setSupportActionBar(binding.topAppBar as Toolbar)

        setContentView(view)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initView()

        setUpObservers()

        viewModel.getCocktailByName(Constants.defaultSearch)
    }

    private fun initView() {

        adapter = object : BaseRecyclerViewAdapter(viewModel) {
            override fun getLayoutId(position: Int): Int {
                return R.layout.layout_cocktail_item
            }

            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return CocktailItemViewHolder(view, this@CocktailActivity)
            }
        }

        binding.cocktailRecyclerView.adapter = adapter
        binding.cocktailRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cocktailRecyclerView.setHasFixedSize(true)

    }


    private fun setUpObservers() {

        viewModel.cocktailsLoaded.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                var search: String = if (text.isNullOrBlank())
                    Constants.defaultSearch
                else
                    text
                viewModel.getCocktailByName(search)
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }


}