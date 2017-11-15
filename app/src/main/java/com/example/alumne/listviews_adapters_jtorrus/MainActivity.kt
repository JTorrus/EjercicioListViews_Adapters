package com.example.alumne.listviews_adapters_jtorrus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.alumne.listviews_adapters_jtorrus.adapter.CustomAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(this, "${p2}", Toast.LENGTH_LONG).show()
    }

    private lateinit var data: ArrayList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDataModel()

        listView.adapter = CustomAdapter(this, data)

        listView.onItemClickListener = this
    }

    fun createDataModel() {
        data = ArrayList<ItemModel>()

        val namesOfItems: Array<String> = this.resources.getStringArray(R.array.names_of_items)
        val stocksOfItems: IntArray = this.resources.getIntArray(R.array.stocks_of_items)

        var item: ItemModel

        for (i in 0 until namesOfItems.size) {
            item = ItemModel(namesOfItems[i], stocksOfItems[i], this.resources.getIdentifier("smartphone", "drawable", this.packageName))
            data.add(item)
        }
    }
}
