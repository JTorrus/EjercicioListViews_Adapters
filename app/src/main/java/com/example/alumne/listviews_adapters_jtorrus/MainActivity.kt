package com.example.alumne.listviews_adapters_jtorrus

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.AdapterView
import android.widget.Toast
import com.example.alumne.listviews_adapters_jtorrus.adapter.SmartphoneAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.Smartphone
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    val SELECTED_QUANTITY = "user_input"
    val SELECTED_ELEMENT = "element_selected"
    private lateinit var data: ArrayList<Smartphone>

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val intent = Intent(this@MainActivity, SelectedActivity::class.java)

        val quantity = p1?.qty_to_buy?.selectedItem as Int
        val element: Smartphone = p0?.getItemAtPosition(p2) as Smartphone

        intent.putExtra(SELECTED_QUANTITY, quantity)
        intent.putExtra(SELECTED_ELEMENT, element)

        startActivityForResult(intent, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDataModel()

        listView.adapter = SmartphoneAdapter(this, data)
        listView.onItemClickListener = this

        button_to_confirm.visibility = GONE
        button_to_cancel.visibility = GONE
    }

    private fun createDataModel() {
        data = ArrayList<Smartphone>()

        val namesOfItems: Array<String> = this.resources.getStringArray(R.array.names_of_items)
        val stocksOfItems: IntArray = this.resources.getIntArray(R.array.stocks_of_items)

        var item: Smartphone

        for (i in 0 until namesOfItems.size) {
            item = Smartphone(namesOfItems[i], stocksOfItems[i], this.resources.getIdentifier(this.resources.getString(R.string.name_of_images), this.resources.getString(R.string.name_type_of_images), this.packageName))
            data.add(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val messageOk = resources.getString(R.string.activity_messageOK)

            Toast.makeText(applicationContext, messageOk, Toast.LENGTH_LONG).show()
        } else {
            val messageKo = resources.getString(R.string.activity_messageKO)

            Toast.makeText(applicationContext, messageKo, Toast.LENGTH_LONG).show()
        }
    }
}


