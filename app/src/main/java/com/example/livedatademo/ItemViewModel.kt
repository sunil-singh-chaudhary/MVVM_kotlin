package com.example.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    init {
        loadItems()
    }

    private fun loadItems() {
        // Simulating data loading from a data source
        val items = mutableListOf(
            Item(1, "Item 1"),
            Item(2, "Item 2"),
            Item(3, "Item 3"),
            Item(4, "Item 4"),
            Item(5, "Item 5"),
            Item(6, "Item 6")


        )


        _itemList.value = items // Update LiveData synchronously
    }
    fun addItem(newItem: Item) {
        val currentList = _itemList.value.orEmpty().toMutableList()
        currentList.add(newItem)
        _itemList.postValue(currentList) // Use postValue to update LiveData on the main thread
    }


}
