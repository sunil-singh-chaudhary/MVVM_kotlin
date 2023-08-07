import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.livedatademo.ItemAdapter
import com.example.livedatademo.ItemViewModel
import com.example.livedatademo.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        val adapter = ItemAdapter()

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter

        // Observe changes in the itemList LiveData
        viewModel.itemList.observe(
            this,
        ) { items ->
            adapter.submitList(items)
        }
    }
}
