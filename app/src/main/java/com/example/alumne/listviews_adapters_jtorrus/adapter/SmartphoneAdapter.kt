package com.example.alumne.listviews_adapters_jtorrus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Spinner
import com.example.alumne.listviews_adapters_jtorrus.R
import com.example.alumne.listviews_adapters_jtorrus.model.Smartphone
import kotlinx.android.synthetic.main.list_item.view.*

class SmartphoneAdapter(internal var context: Context, internal var data: ArrayList<Smartphone>): BaseAdapter() {
    private var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    internal var quantity: Int = 0

    constructor(context: Context, data: ArrayList<Smartphone>, quantity: Int): this(context, data) {
        this.quantity = quantity
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val adapter = ArrayAdapter<Int>(context, android.R.layout.simple_spinner_dropdown_item)

        if (view == null) {
            view = inflater.inflate(R.layout.list_item, null)
        }

        view?.image_of_item?.setImageResource(data[position].image)
        view?.name_of_item?.text = data[position].name
        view?.stock_of_item?.text = data[position].stock.toString()

        for (key in 0..data[position].stock) {
            adapter.add(key)
        }

        view?.qty_to_buy?.adapter = adapter

        return view!!
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}