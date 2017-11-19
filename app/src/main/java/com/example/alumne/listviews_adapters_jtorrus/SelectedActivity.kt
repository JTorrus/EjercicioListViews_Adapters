package com.example.alumne.listviews_adapters_jtorrus


import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alumne.listviews_adapters_jtorrus.adapter.SmartphoneAdapter
import com.example.alumne.listviews_adapters_jtorrus.model.Smartphone
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class SelectedActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            button_to_confirm.id -> {
                if (qty_to_buy.selectedItem != 0) {
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                }
            }

            button_to_cancel.id -> {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    private var selectedData: ArrayList<Smartphone> = ArrayList<Smartphone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quantity = intent.getIntExtra(MainActivity::SELECTED_QUANTITY.get(MainActivity()), 0)
        val element: Smartphone = intent.getParcelableExtra(MainActivity::SELECTED_ELEMENT.get(MainActivity()))

        selectedData.add(element)

        listView.adapter = SmartphoneAdapter(this, selectedData, quantity)

        button_to_cancel.setOnClickListener(this)
        button_to_confirm.setOnClickListener(this)
    }
}
