package com.example.livedatademo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
     val click_btn: Button
        get() = findViewById(R.id.click)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        val adapter = ItemAdapter()

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        click_btn.setOnClickListener {
            viewModel.addItem(Item(100, "rocky"))

            //so the concept to update livemodel not xml , livemodel auto obsorve and update xml or recyclerview \
            //this is the concept of livemodel data in kotlin here in Flutter we have provider or statemanagement
            //to this but in android we have inbuilt functionality of updaing live data
        }
        // Observe changes in the itemList LiveData
        viewModel.itemList.observe(
            this,
        ) { items ->
            println("items is $items")
            adapter.submitList(items)
        }
    }
}
