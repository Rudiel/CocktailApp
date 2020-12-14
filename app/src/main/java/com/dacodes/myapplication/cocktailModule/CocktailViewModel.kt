package com.dacodes.myapplication.cocktailModule

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dacodes.myapplication.base.BaseViewModel
import com.dacodes.myapplication.base.ListViewModel
import com.dacodes.myapplication.models.Drink
import com.dacodes.myapplication.models.DrinkResponse
import com.dacodes.myapplication.repository.CocktailRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CocktailViewModel @Inject constructor(application: Application) : BaseViewModel(application),
    ListViewModel {

    @Inject
    lateinit var cocktailRepository: CocktailRepository

    var loadingStatus: MutableLiveData<Boolean> = MutableLiveData()
    var errorMessage: MutableLiveData<String> = MutableLiveData()
    var cocktailsLoaded: MutableLiveData<Boolean> = MutableLiveData()
    private var cocktailList: MutableList<Drink> = mutableListOf()
    var emptyState: MutableLiveData<Boolean> = MutableLiveData()

    fun getCocktailByName(name: String) {

        cocktailList.clear()

        loadingStatus.postValue(true)
        cocktailRepository.getCocktails(name).enqueue(object : Callback<DrinkResponse> {
            override fun onFailure(call: Call<DrinkResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
                emptyState.postValue(true)
                loadingStatus.postValue(false)
            }

            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>) {
                if (response.isSuccessful) {
                    val cocktails = response.body()?.drinks?.toMutableList() ?: mutableListOf()
                    if (cocktails.size > 0) {
                        cocktailList = cocktails
                        emptyState.postValue(false)
                    } else {
                        emptyState.postValue(true)
                    }
                    cocktailsLoaded.postValue(true)
                }
                loadingStatus.postValue(false)
            }
        })
    }

    override fun numberOfItems(): Int {
        return cocktailList.size
    }

    override fun itemAt(position: Int): BaseViewModel {
        return CocktailItemViewModel(getApplication(), cocktailList[position])
    }

    override fun selectItemAt(position: Int) {
        TODO("Not yet implemented")
    }

    override fun morePagesAvailable(): Boolean {
        TODO("Not yet implemented")
    }


}