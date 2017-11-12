package com.example.alumne.listviews_adapters_jtorrus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alumne.listviews_adapters_jtorrus.adapter.CustomAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private lateinit var data: ArrayList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDataModel()

        listView.adapter = CustomAdapter(this, data, R.layout.list_item)
    }

    fun createDataModel() {
        data = ArrayList<ItemModel>()

        val namesOfItems: Array<String> = this.resources.getStringArray(R.array.names_of_items)
        val stocksOfItems: IntArray = this.resources.getIntArray(R.array.stocks_of_items)

        var item: ItemModel

        for (i in 0..namesOfItems.size) {
            item = ItemModel(namesOfItems[i], stocksOfItems[i], this.resources.getIdentifier("ic_stay_current_portrait", "drawable", this.packageName))
            data.add(item)
        }
    }
}
